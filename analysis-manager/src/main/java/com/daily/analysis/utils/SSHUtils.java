package com.daily.analysis.utils;


import ch.ethz.ssh2.*;
import com.daily.analysis.exception.AuthErrorException;
import com.daily.analysis.exception.CommandErrorException;
import com.daily.analysis.exception.ConnectTimeoutException;
import com.daily.analysis.model.pojo.AnaConfig;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by dailinyi on 15/5/23.
 */
public class SSHUtils {
    public static final int TIMEOUT = Integer.valueOf(PropertiesUtils.getProperty("config.default.server.timeout"));
    public static final String CHARSET = Charset.forName(PropertiesUtils.getProperty("config.default.server.charset"))
            .toString();

    public static String exec(AnaConfig config,String command) throws IOException{
        return exec(config.getServerIp(),config.getServerUsername(),config.getServerPassword(),command);
    }

//    public static void upload(String ip,String user,String password,String command) throws IOException{
//        Connection con = new Connection(ip);
//        ConnectionInfo info = null;
//        SFTPOutputStream  sftp = null ;
//        InputStream stdOut = null;
//        InputStream stdErr = null;
//        String outStr = "";
//        String outErr = "";
//        //连接超时
//        try {
//            info = con.connect();
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new ConnectTimeoutException();
//        }
//
//        //登录失败
//        try {
//            con.authenticateWithPassword(user, password);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new AuthErrorException();
//        }
//
//        //无法打开session
//        try {
//            sftp.write(new byte[]);
//
//
//            if (StringUtils.isNotBlank(outErr)){
//                throw new CommandErrorException(outErr);
//            }
//
//            return outStr;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new CommandErrorException() ;
//        }
//
//    }

    public static String exec(String ip,String user,String password,String command) throws IOException{

        Connection con = new Connection(ip);
        ConnectionInfo info = null;
        Session session = null ;
        InputStream stdOut = null;
        InputStream stdErr = null;
        String outStr = "";
        String outErr = "";
        //连接超时
        try {
            info = con.connect();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ConnectTimeoutException();
        }

        //登录失败
        try {
            con.authenticateWithPassword(user, password);
        } catch (IOException e) {
            e.printStackTrace();
            throw new AuthErrorException();
        }

        //无法打开session
        try {
            session = con.openSession();
            session.execCommand(command,CHARSET);
            stdOut = new StreamGobbler(session.getStdout());
            outStr = processStream(stdOut, CHARSET);

            stdErr = new StreamGobbler(session.getStderr());
            outErr = processStream(stdErr, CHARSET);


            session.waitForCondition(ChannelCondition.EXIT_STATUS, TIMEOUT);

            if (StringUtils.isNotBlank(outErr)){
                throw new CommandErrorException(outErr);
            }

            return outStr;

        } catch (IOException e) {
            e.printStackTrace();
            throw new CommandErrorException() ;
        }


    }

    private static String processStream(InputStream in, String charset) throws IOException {
        byte[] b = new byte[1024];
        StringBuilder sb = new StringBuilder();
        for   (int   n;   (n   =   in.read(b))   !=   -1;)   {


            sb.append(new String(b,0,n,charset));

        }

        return sb.toString();
    }
}

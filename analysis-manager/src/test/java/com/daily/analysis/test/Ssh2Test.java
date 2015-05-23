package com.daily.analysis.test;

import ch.ethz.ssh2.*;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by dailinyi on 15/5/22.
 */
public class Ssh2Test {

    public static final int TIMEOUT = 1;
    private String     charset = Charset.defaultCharset().toString();

    @Test
    public void testSSH2(){
        InputStream stdOut = null;
        InputStream stdErr = null;
        String outStr = "";
        String outErr = "";
        int ret = -1;
        Connection con = new Connection("123.57.210.213");
        try {
        ConnectionInfo info = con.connect();
        boolean result = con.authenticateWithPassword("root", "dayongfalw");
        Session session = con.openSession();
        session.execCommand("lss");
            stdOut = new StreamGobbler(session.getStdout());
            outStr = processStream(stdOut, charset);

            stdErr = new StreamGobbler(session.getStderr());
            outErr = processStream(stdErr, charset);

            session.waitForCondition(ChannelCondition.EXIT_STATUS, TIMEOUT);

            System.out.println("outStr=" + outStr);
            System.out.println("outErr=" + outErr);

            ret = session.getExitStatus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String processStream(InputStream in, String charset) throws Exception {
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while (in.read(buf) != -1) {
            sb.append(new String(buf, charset));
        }
        return sb.toString();
    }

}

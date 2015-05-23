package com.daily.analysis.service.impl;

import com.daily.analysis.model.pojo.AnaConfig;
import com.daily.analysis.service.CommandService;
import com.daily.analysis.utils.PropertiesUtils;
import com.daily.analysis.utils.SSHUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dailinyi on 15/5/23.
 */
@Service
public class CommandServiceImpl implements CommandService {

    @Override
    public String getSnortConfig(AnaConfig config) throws IOException{
        if (StringUtils.isEmpty(config.getSnortConfUrl())){
            config.setSnortConfUrl(PropertiesUtils.getProperty("config.default.snort.conf"));
        }

        StringBuilder command = new StringBuilder().append(" cat ")
                .append(config.getSnortConfUrl());

        return SSHUtils.exec(config,command.toString());
    }

    @Override
    public void mergeSnortConfig(AnaConfig config,String newConfig) throws IOException {
        if (StringUtils.isEmpty(config.getSnortConfUrl())){
            config.setSnortConfUrl(PropertiesUtils.getProperty("config.default.snort.conf"));
        }

        String backFileName = "snort.conf." + new DateTime().toLocalDateTime();

        StringBuilder sb = new StringBuilder();

        //将源文件拷贝到新路径下
        sb.append(" mv ").append(config.getSnortConfUrl()).append(" ")
                .append(PropertiesUtils.getProperty("config.tmp.url")).append("/snortConf/").append(backFileName);

        //将新文件另存为snort.conf
        sb.append(" && ");
        String[] splitCommand = newConfig.split("\\n");
        for (int i = 0 ; i<splitCommand.length;i++){
//            sb = new StringBuilder();
            sb.append(" echo ").append("'").append(splitCommand[i].replace("'","")).append("'")
                    .append(" >> ").append(config.getSnortConfUrl());


            if (i != splitCommand.length - 1){
                sb.append(" && ");
            }

        }
        SSHUtils.exec(config, sb.toString());
    }

    @Override
    public List<String> getRulesList(AnaConfig config) throws IOException {
        if (StringUtils.isEmpty(config.getSnortConfUrl())){
            config.setSnortConfUrl(PropertiesUtils.getProperty("config.default.snort.conf"));
        }

        StringBuilder command = new StringBuilder().append(" ls ")
                .append(config.getSnortConfUrl());

        String s = SSHUtils.exec(config,command.toString());
        return Arrays.asList(s.split("\\n"));
    }
}

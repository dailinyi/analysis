package com.daily.analysis.service.impl;

import com.daily.analysis.model.pojo.AnaConfig;
import com.daily.analysis.service.CommandService;
import com.daily.analysis.utils.PropertiesUtils;
import com.daily.analysis.utils.SSHUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

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
}

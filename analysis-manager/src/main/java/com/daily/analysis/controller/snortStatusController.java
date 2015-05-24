package com.daily.analysis.controller;

import com.daily.analysis.service.CommandService;
import com.daily.analysis.service.ConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by dailinyi on 15/5/24.
 */
@Controller
@RequestMapping("/status")
public class SnortStatusController {
    @Resource
    private ConfigService configService;
    @Resource
    private CommandService commandService;


    @RequestMapping("/snortStatus")
    public String list(String serverName ,HttpServletRequest request){
//        String conf = listSnortConf(serverName);

//        request.setAttribute("conf",conf);
        request.setAttribute("serverName",serverName);
        return "config/snortStatusList";
    }

}

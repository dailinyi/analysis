package com.daily.analysis.controller;

import com.daily.analysis.exception.ConfigErrorException;
import com.daily.analysis.model.pojo.AnaConfig;
import com.daily.analysis.service.CommandService;
import com.daily.analysis.service.ConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by dailinyi on 15/5/23.
 */
@Controller
@RequestMapping("/config")
public class ConfigController {
    @Resource
    private ConfigService configService;
    @Resource
    private CommandService commandService;

    @ResponseBody
    @RequestMapping("/snortConf")
    public String listSnortConf(String serverName){
        serverName = "test";
        try {
            AnaConfig config = configService.getListByName(serverName);
            String outConf = commandService.getSnortConfig(config);
            return outConf;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @RequestMapping("/snortConfList")
    public String list(HttpServletRequest request){
        String conf = listSnortConf("");
        request.setAttribute("conf",conf);
        return "config/list";
    }
}

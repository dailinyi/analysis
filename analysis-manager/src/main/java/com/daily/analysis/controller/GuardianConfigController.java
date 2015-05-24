package com.daily.analysis.controller;

import com.daily.analysis.exception.ConfigErrorException;
import com.daily.analysis.model.pojo.AnaConfig;
import com.daily.analysis.service.CommandService;
import com.daily.analysis.service.ConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by dailinyi on 15/5/23.
 */
@Controller
@RequestMapping("/config")
public class GuardianConfigController {
    @Resource
    private ConfigService configService;
    @Resource
    private CommandService commandService;


    @RequestMapping("/guardianConf")
    public String list(String serverName ,HttpServletRequest request){
        try {
            AnaConfig config = configService.getConfigByName(serverName);
            String guardianConfig = commandService.getGuardianConfig(config);

            request.setAttribute("config",guardianConfig);
            request.setAttribute("serverName",serverName);

            return "config/guardianList";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage",e.getMessage());
        }

        return "common/error";
    }




}

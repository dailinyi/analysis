package com.daily.analysis.controller;

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
@RequestMapping("/log")
public class GuardianLogController {
    @Resource
    private ConfigService configService;
    @Resource
    private CommandService commandService;


    @RequestMapping("/guardianLog")
    public String list(String serverName ,HttpServletRequest request){
        try {
            AnaConfig config = configService.getConfigByName(serverName);
            String guardianConfig = commandService.getGuardianLog(config);

            request.setAttribute("config",guardianConfig);
            request.setAttribute("serverName",serverName);

            return "log/guardianList";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage",e.getMessage());
        }

        return "common/error";
    }




}

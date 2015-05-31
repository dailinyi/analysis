package com.daily.analysis.controller;

import com.daily.analysis.exception.ConfigErrorException;
import com.daily.analysis.model.LogInfo;
import com.daily.analysis.model.Result;
import com.daily.analysis.model.pojo.AnaConfig;
import com.daily.analysis.service.CommandService;
import com.daily.analysis.service.ConfigService;
import com.daily.analysis.utils.ResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

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
    public String list(String serverName ,Boolean snortOnly ,HttpServletRequest request){

        try {
            AnaConfig config = configService.getConfigByName(serverName);
            boolean snortStatus = commandService.getSnortStatus(config);
            boolean guardianStatus = commandService.getGuardianStatus(config);

            request.setAttribute("snortStatus",snortStatus);
            request.setAttribute("snortOnly",snortOnly);
            request.setAttribute("guardianStatus",guardianStatus);
            request.setAttribute("serverName",serverName);
            return "config/snortStatusList";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @ResponseBody
    @RequestMapping("/snortStart")
    public Result startSnort(String serverName,HttpServletRequest request){
        try {
            AnaConfig config = configService.getConfigByName(serverName);
            commandService.setSnortStart(config);

            return ResultUtils.successResult();
        } catch (Exception e){
            e.printStackTrace();
            return ResultUtils.failResult(e.getMessage());
        }

    }

    @ResponseBody
    @RequestMapping("/snortStop")
    public Result stopSnort(String serverName,HttpServletRequest request){
        try {
            AnaConfig config = configService.getConfigByName(serverName);
            commandService.setSnortStop(config);

            return ResultUtils.successResult();
        } catch (Exception e){
            e.printStackTrace();
            return ResultUtils.failResult(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/guardianStart")
    public Result startGuardian(String serverName,HttpServletRequest request){
        try {
            AnaConfig config = configService.getConfigByName(serverName);
            commandService.setGuardianStart(config);

            return ResultUtils.successResult();
        } catch (Exception e){
            e.printStackTrace();
            return ResultUtils.failResult(e.getMessage());
        }

    }

    @ResponseBody
    @RequestMapping("/guardianStop")
    public Result stopGuardian(String serverName,HttpServletRequest request){
        try {
            AnaConfig config = configService.getConfigByName(serverName);
            commandService.setGuardianStop(config);

            return ResultUtils.successResult();
        } catch (Exception e){
            e.printStackTrace();
            return ResultUtils.failResult(e.getMessage());
        }
    }




}

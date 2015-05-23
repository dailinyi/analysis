package com.daily.analysis.controller;

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
//        serverName = "test";
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
    public String list(String serverName ,HttpServletRequest request){
        String conf = listSnortConf(serverName);

        request.setAttribute("conf",conf);
        request.setAttribute("serverName",serverName);
        return "config/list";
    }

    @ResponseBody
    @RequestMapping("/mergeSnortConf")
    public Result merge(String configText ,String serverName, HttpServletRequest request){
       try {

           AnaConfig config = configService.getListByName(serverName);
           commandService.mergeSnortConfig(config,configText);

           return ResultUtils.successResult();
       } catch (Exception e){
           e.printStackTrace();
           return ResultUtils.failResult(e.getMessage());
       }
    }

    @ResponseBody
    @RequestMapping("/listRules")
    public Result listRules(String configText ,String serverName, HttpServletRequest request){
        try {

            AnaConfig config = configService.getListByName(serverName);
            commandService.mergeSnortConfig(config,configText);

            return ResultUtils.successResult();
        } catch (Exception e){
            e.printStackTrace();
            return ResultUtils.failResult(e.getMessage());
        }
    }
}

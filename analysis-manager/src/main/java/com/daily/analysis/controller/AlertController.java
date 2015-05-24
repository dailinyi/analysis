package com.daily.analysis.controller;

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
import java.util.List;

/**
 * Created by dailinyi on 15/5/17.
 */
@Controller
@RequestMapping("/alert")
public class AlertController {

    @Resource
    private ConfigService configService;
    @Resource
    private CommandService commandService;

    @RequestMapping("/list")
    public String list(String serverName , HttpServletRequest request){
        try {
            request.setAttribute("serverName",serverName);
            return "alert/list";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "common/error";
    }

    @ResponseBody
    @RequestMapping("/listAjax")
    public List<LogInfo> listRulesDetail(String serverName,String ruleName, HttpServletRequest request){
        try {

            AnaConfig serverConfig = configService.getConfigByName(serverName);
            List<LogInfo> result = commandService.getAlertList(serverConfig);
            return result;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

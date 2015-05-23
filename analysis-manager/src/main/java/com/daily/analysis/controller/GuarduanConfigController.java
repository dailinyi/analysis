package com.daily.analysis.controller;

import com.daily.analysis.model.FileInfo;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dailinyi on 15/5/23.
 */
@Controller
@RequestMapping("/config")
public class GuarduanConfigController {
    @Resource
    private ConfigService configService;
    @Resource
    private CommandService commandService;


    @RequestMapping("/guarduanConf")
    public String list(String serverName ,HttpServletRequest request){
        String conf = listSnortConf(serverName);

        request.setAttribute("conf",conf);
        request.setAttribute("serverName",serverName);
        return "config/list";
    }




}

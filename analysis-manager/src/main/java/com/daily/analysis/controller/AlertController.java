package com.daily.analysis.controller;

import com.daily.analysis.service.ConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by dailinyi on 15/5/17.
 */
@Controller
public class AlertController {

    @Resource
    private ConfigService configService;

    @RequestMapping("/alert/list")
    public String list(HttpServletRequest request){

        return "ack/list";
    }
    @ResponseBody
    @RequestMapping("/alert/list1")
    public Object list1(HttpServletRequest request){

        return null;

    }
}

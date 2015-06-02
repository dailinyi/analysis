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
 * Created by dailinyi on 15/5/13.
 */
@Controller
//@RequestMapping("/")
public class UserTestControler {

    @Resource
    private ConfigService configService;
    @Resource
    private CommandService commandService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        try {
            //gateway
            AnaConfig gateway = configService.getConfigByName("GATEWAY");
            request.setAttribute("gatewaySnortStatus",commandService.getSnortStatus(gateway));

            //http
            AnaConfig http = configService.getConfigByName("HTTP");
            request.setAttribute("httpSnortStatus",commandService.getSnortStatus(http));
            request.setAttribute("httpGuardianStatus",commandService.getGuardianStatus(http));

            //ftp
            AnaConfig ftp = configService.getConfigByName("HTTP");
            request.setAttribute("ftpSnortStatus",commandService.getSnortStatus(ftp));
            request.setAttribute("ftpGuardianStatus",commandService.getGuardianStatus(ftp));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

}

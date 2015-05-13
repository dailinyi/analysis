package com.daily.analysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dailinyi on 15/5/13.
 */
@Controller
//@RequestMapping("/")
public class UserTestControler {

    @RequestMapping("/index")
    public String index(){
        System.out.println("abcd");
        return "index";
    }

}

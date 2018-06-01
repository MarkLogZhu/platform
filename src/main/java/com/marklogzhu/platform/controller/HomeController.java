package com.marklogzhu.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home.page")
    public String home(){
        return "home";
    }
    @RequestMapping("/index.page")
    public String index(){
        return "index";
    }
}

package com.example.elog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author gorge
 * @Version 1.0
 * @Date 2023/4/30 13:14
 **/
@Controller
public class TestController {

    @RequestMapping("/indexxx")
    public String index(){
        System.out.println("xx");
        return "index";
    }
}

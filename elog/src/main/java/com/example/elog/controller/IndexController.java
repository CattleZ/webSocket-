package com.example.elog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author gorge
 * @Version 1.0
 * @Date 2023/4/30 13:14
 **/
@Controller
public class IndexController extends BaseController{

    @RequestMapping("")
    public String index(){
        req.setAttribute("categoryId",0);
        return "index";
    }
}

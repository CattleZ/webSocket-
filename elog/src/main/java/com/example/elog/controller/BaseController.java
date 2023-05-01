package com.example.elog.controller;


import com.example.elog.service.MPostService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author gorge
 * @Version 1.0
 * @Date 2023/4/30 17:04
 **/

public class BaseController {
    /**
     * 注入全局的req对象，用来全局处理对应的请求信息
     */
    @Resource
    HttpServletRequest req;

    @Resource
    MPostService mPostService;
}

package com.example.elog.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elog.service.MCommentService;
import com.example.elog.service.MPostService;
import org.springframework.web.bind.ServletRequestUtils;

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

    @Resource
    MCommentService mCommentService;

    public Page getPage(){
        //分页查询博客的基本信息
        // 获取当前页面参数
        int pn = ServletRequestUtils.getIntParameter(req,"pn",1);
        int size = ServletRequestUtils.getIntParameter(req,"size",2);
        return new Page(pn,size);
    }
}

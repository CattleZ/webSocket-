package com.example.elog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elog.Vo.MPostVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
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
        //分页查询博客的基本信息
        // 获取当前页面参数
        int pn = ServletRequestUtils.getIntParameter(req,"pn",1);
        int size = ServletRequestUtils.getIntParameter(req,"size",2);
        Page page = new Page(pn,size);
        // 分页参数 置顶 分类 用户 精选 排序
        IPage<MPostVo> results = mPostService.paging(page,null,null,null,null,"created");
        req.setAttribute("categoryId",0);
        return "index";
    }
}

package com.example.elog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author gorge
 * @Version 1.0
 * @Date 2023/4/30 15:16
 **/
@Controller
public class PostController {

    /**
     * 分类
     * @param id 冒号后面可以通过正则表达式设置类型为数字类型
     * @return
     */
    @GetMapping("/category/{id:\\d*}")
    public String category(@PathVariable(name="id") Long id){
        return "post/category";
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @GetMapping("/detail/{id:\\d*}")
    public String detail(@PathVariable(name="id") Long id){
        return "post/detail";
    }
}

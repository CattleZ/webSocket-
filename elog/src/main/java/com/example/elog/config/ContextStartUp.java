package com.example.elog.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.elog.entity.MCategory;
import com.example.elog.service.MCategoryService;
import com.example.elog.service.MPostService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * 设置项目启动的时候，需要执行的内容
 * 1. ApplicationRunner 可以实现在应用启动的时候加载
 * 2. ServletContextAware 对象可以实现应用级别的数据注入
 * @Author gorge
 * @Version 1.0
 * @Date 2023/4/30 19:21
 **/
@Component
public class ContextStartUp implements ApplicationRunner, ServletContextAware {
    /**
     * 加载分类列表
     */
    @Resource
    MCategoryService mCategoryService;
    /**
     * 加载本周热议
     */
    @Resource
    MPostService mPostService;
    /**
     * ServletContext对象: 是表示整个WEB应用的对象。ServletContext对象是在服务器启动，
     * web应用被加载之后，服务器会立即创建出代表整个web应用的ServletContext对象。创建之后，
     * 该对象会一直驻留在服务器的内存中，唯一的表示当前web应用。
     * 直到服务器关闭或者web应用被移除容器为止，随着web应用的销毁，
     * ServletContext对象也会跟着销毁。
     */
    @Resource
    ServletContext servletContext;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 查询出分类列表没有被逻辑删除的数据
        List<MCategory> mCategoryList = mCategoryService.list(new QueryWrapper<MCategory>()
                .eq("status",0));
        // 实现分类列表数据的全局注入
        servletContext.setAttribute("categories",mCategoryList);

        // 加载本周热议
        mPostService.initWeekRank();
    }

    /**
     * 获取servletContext对象
     * @param servletContext
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}

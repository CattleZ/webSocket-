package com.example.elog.config;

import com.example.elog.template.PostsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class FreemarkerConfig {

    @Resource
    private freemarker.template.Configuration configuration;

    @Resource
    PostsTemplate postsTemplate;


    @PostConstruct
    public void setUp() {
        configuration.setSharedVariable("posts", postsTemplate);

    }

}
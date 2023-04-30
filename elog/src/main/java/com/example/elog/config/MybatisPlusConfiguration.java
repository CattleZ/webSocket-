package com.example.elog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author gorge
 * @Version 1.0
 * @Date 2023/4/30 19:15
 **/
@Configuration
@MapperScan("com.example.elog.mapper")
public class MybatisPlusConfiguration {
}

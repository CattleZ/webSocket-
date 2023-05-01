package com.example.elog.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author gorge
 * @Version 1.0
 * @Date 2023/4/30 19:15
 **/
@Configuration
// 分页插件需要导入
@EnableTransactionManagement
@MapperScan("com.example.elog.mapper")
public class MybatisPlusConfiguration {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面，大于最大页后操作，true表示调回到首页，false继续请求，默认false
        paginationInterceptor.setOverflow(false);
        // 设置最大单页数量，默认500 ，-1不受限制
        paginationInterceptor.setLimit(500);
        return paginationInterceptor;
    }
}

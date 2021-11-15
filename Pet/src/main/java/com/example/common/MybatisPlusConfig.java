package com.example.common;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  mybatis-plus  Paging plugin
 */
@Configuration
public class MybatisPlusConfig {

    /**
     *  Paging plugin
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}

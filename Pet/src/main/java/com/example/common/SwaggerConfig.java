package com.example.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getUserDocket(){
        ApiInfo apiInfo=new ApiInfoBuilder()
                //api title
                .title("x-admin接口管理")
                //api describe
                .description("x-admin相关接口文档")
                //version
                .version("1.0.0")
                .build();
        //（swagger2） Document type
        return new Docket(DocumentationType.SWAGGER_2)
                //API meta information in the response
                .apiInfo(apiInfo)
                //Start the builder for api selection
                .select()
                //Scan interface packets
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                //Path filter (scan all paths)
                .paths(PathSelectors.any())
                .build();
    }
}

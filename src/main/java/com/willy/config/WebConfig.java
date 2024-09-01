package com.willy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 處理靜態資源
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        // 將未知路由轉發到 index.html，處理前端路由
//        registry.addViewController("/{path:[^\\.]*}")
//                .setViewName("forward:/index.html");
//    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 設定應用於所有路徑
                .allowedOrigins("http://localhost:8080") // 允許的前端 URL，根據實際情況修改
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允許的方法
                .allowedHeaders("*") // 允許的頭部信息
                .allowCredentials(true); // 是否允許憑證
    }
    
}
package com.example.sl_tech.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        String path = System.getProperty("user.dir") + "/src/main/resources/static/public/file/";
        registry.addResourceHandler("/public/file/**").addResourceLocations("file:"+path);

    }

}

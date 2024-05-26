package com.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/static/admin/");
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/user/");
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:D:/Workspaces/Java/web/spring-mvc/bookstore/uploads/");
    }
	
	@Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(10*1024*1024);
        return resolver;
    }
}

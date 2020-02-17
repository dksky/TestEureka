package com.cnblogs.yjmyzz.spring.cloud.study.gateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomPathConfig extends WebMvcConfigurerAdapter {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("api-order/**")
        		.addResourceLocations("classpath:/devToolStatic/");
        /*registry.addResourceHandler("api-order/devTool.html")
                .addResourceLocations("classpath:/devToolStatic/");
		registry.addResourceHandler("allDeveloperRoutes.html")
                .addResourceLocations("classpath:/devToolStatic/");*/
		
		registry.setOrder(-2147483647);

    }
	
}

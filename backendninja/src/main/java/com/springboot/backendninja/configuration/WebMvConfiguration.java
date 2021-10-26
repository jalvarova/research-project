package com.springboot.backendninja.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.springboot.backendninja.interceptor.RequestInterceptorHandler;

@Configuration
public class WebMvConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private RequestInterceptorHandler requestInterceptorHandler;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(requestInterceptorHandler);
	}
}

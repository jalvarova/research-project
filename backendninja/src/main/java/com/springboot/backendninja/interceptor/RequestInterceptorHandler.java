package com.springboot.backendninja.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.springboot.backendninja.controller.FormController;

@Component
public class RequestInterceptorHandler extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(FormController.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		long startTime = (long) request.getAttribute("startTime");
		LOG.info("INITIAL : " + (int)startTime + "ms");
		long finalTime = System.currentTimeMillis();
		LOG.info("Finally : " + (int)finalTime + "ms");
		long totalTime = finalTime - startTime;
		LOG.info("---REQUEST---- URL: " + request.getRequestURL().toString() + " ---TOTAL--- TIME: " + totalTime+ ".ms");
	}

}

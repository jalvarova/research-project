package com.springboot.backendninja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

	@ExceptionHandler(Exception.class)
	public String showInternalServerError(){
		
		return "error/500";
	}
}

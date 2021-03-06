package com.abhi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DatabaseErrorHandler {
	
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex){
		ex.printStackTrace();
		return "error";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException ex){
		ex.printStackTrace();
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
            throw e;
        
        e.printStackTrace();
        return "error";
	}
}

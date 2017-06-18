package com.mvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器 
 * @author Administrator
 *
 */
@Component
public class CustomExceptionResolver implements HandlerExceptionResolver{

	/**
	 * handler为处理适配器要执行的Handle对象
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		//解析异常
		//如果该异常为自定义异常，直接取出异常信息，在错误页面显示
		//如果该异常不是自定义异常，构造一个自定义异常类型，错误信息为：未知错误...
		CustomException customException = null;
		if(ex instanceof CustomException){
			customException = (CustomException) ex;
		}else{
			customException = new CustomException("未知错误");
		}
		
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("message", message);
		
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}

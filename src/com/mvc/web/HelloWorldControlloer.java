package com.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldControlloer implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		System.out.println("controller.........");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", "HelloWorld!!!");
		
		mav.setViewName("/WEB-INF/jsp/hello.jsp");
		
		return mav;
	}

}

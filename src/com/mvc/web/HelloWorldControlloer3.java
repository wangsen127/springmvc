package com.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldControlloer3{

	@RequestMapping("/hello4")
	public ModelAndView hello()  {
		System.out.println("controller3333.........");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", "HelloWorld333333333333333!!!");
		
		mav.setViewName("/WEB-INF/jsp/hello.jsp");
		
		return mav;
	}

}

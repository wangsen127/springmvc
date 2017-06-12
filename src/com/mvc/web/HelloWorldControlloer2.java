package com.mvc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;

public class HelloWorldControlloer2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("controller2.........");
		
		req.setAttribute("message", "HelloWorld2222222222!!!");
		
		req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);;
	}

}

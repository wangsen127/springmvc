package com.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistController {

	@RequestMapping("/regist.html")
	public String openRegist(){
		
		return "regist";
	}
	
	@RequestMapping("/regist.do")
	public String regist(String username,String password){
		
		System.out.println(username + ":" + password);
		
		return "success";
	}
}

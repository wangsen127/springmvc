package com.mvc.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.pojo.User;

@Controller
public class RegistController {

	@RequestMapping("/regist.html")
	public String openRegist(){
		
		return "regist";
	}
	
	@RequestMapping("/regist.do")
	public String regist(String username,String password,Date birthday){
		
		System.out.println(username + ":" + password + ":" + birthday);
		
		return "success";
	}
	
	@RequestMapping("/regist2.do")
	public String regist2(User user){
		
		System.out.println(user);
		
		return "success";
	}
}

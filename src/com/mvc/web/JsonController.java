package com.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.pojo.Dept;

@Controller
public class JsonController {

	@RequestMapping("/showJson.do")
	public String showJson(){
		
		return "json";
	}
	
	@RequestMapping("/json1.do")
	public @ResponseBody Dept json1(Dept dept) throws Exception{
		
		System.out.println("json1.....");
		
		return dept;
	}
	
	@RequestMapping(value="/json2.do")
	public @ResponseBody Dept json2(@RequestBody Dept dept) throws Exception{
		
		System.out.println("json2.....");
		
		return dept;
	}
	
	@RequestMapping(value="/json3.do")
	public @ResponseBody Dept json3(Dept dept) throws Exception{
		
		System.out.println("json3.....");
		
		return dept;
	}
}

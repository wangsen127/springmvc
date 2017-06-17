package com.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.pojo.MapBean;

@Controller
public class MapController {

	@RequestMapping("/showMap.do")
	public String showMap(){
		return "map";
	}
	@RequestMapping("/testMap.do")
	public String testMap(MapBean mapBean){
		System.out.println(mapBean.getMap());
		return "success";
	}
}

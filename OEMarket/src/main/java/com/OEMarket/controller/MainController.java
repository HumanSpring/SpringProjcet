package com.OEMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	// 인덱스
	@GetMapping(value ="index.do" )
	public String mainControll() {
		return "index";
	}
}

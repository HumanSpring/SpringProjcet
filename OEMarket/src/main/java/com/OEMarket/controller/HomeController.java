package com.OEMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		log.info("home controller");
		return "index";
	}
	
	@GetMapping("/member")
	public String dispMember(Model model) {
		log.info("home controller");
		return "/member/member";
	}
	
	@GetMapping("/admin")
	public String dispAdmin(Model model) {
		log.info("home controller");
		return "/member/admin";
	}
	
}

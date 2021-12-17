package com.OEMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
	@GetMapping(value ="/account/join.do" )
	public String AccountJoin() {
		return "account/join";
	}
	
	@GetMapping(value ="/account/login.do" )
	public String AccountLogin() {
		return "account/login";
	}

}

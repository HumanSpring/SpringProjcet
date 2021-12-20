package com.OEMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
	
	// 회원가입
	@GetMapping(value ="/account/join.do" )
	public String AccountJoinForm() {
		return "account/join";
	}
	
	// 로그인
	@GetMapping(value ="/account/login.do" )
	public String AccountLogin() {
		return "account/login";
	}
	
	// 비밀번호 찾기
	@GetMapping(value ="/account/find_pw.do" )
	public String AccountFindPw() {
		return "account/find_pw";
	}
	
	// 아이디 찾기
	@GetMapping(value ="/account/find_id.do" )
	public String AccountFindId() {
		return "account/find_id";
	}

	// 비밀번호 찾기 결과
	@GetMapping(value ="/account/find_pw_result.do" )
	public String AccountFindPwResult() {
		return "account/find_pw_result";
	}
	
}

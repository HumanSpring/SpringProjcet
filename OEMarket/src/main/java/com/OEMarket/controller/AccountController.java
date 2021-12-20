package com.OEMarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.OEMarket.dto.LoginFormDTO;
import com.OEMarket.dto.MemberDTO;
import com.OEMarket.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AccountController {
	
	private final LoginService loginService; 
	
	// 회원가입
	@GetMapping(value ="/account/join.do" )
	public String AccountJoinForm() {
		return "account/join";
	}
	
	// 로그인
	@GetMapping(value ="/account/login.do" )
	public String AccountLogin(@ModelAttribute LoginFormDTO loginForm) {
		return "account/login";
	}
	
	@PostMapping("/account/login.do")
	public String loginAction(@ModelAttribute @Validated LoginFormDTO loginForm, BindingResult bindingResult, @RequestParam(defaultValue = "/") String redirectURL) {
		if(bindingResult.hasErrors()) {
			return "account/login";
		}
	
		MemberDTO loginMember = loginService.login(loginForm.getEmail(), loginForm.getPassword());
	
		if(loginMember == null) {
			bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
			return "account/login";
		}
		
		// 로그인 성공 처리
		
		return "redirect:" + redirectURL;
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

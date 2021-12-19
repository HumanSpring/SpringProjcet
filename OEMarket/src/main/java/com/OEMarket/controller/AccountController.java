package com.OEMarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.OEMarket.dto.MemberForm;
import com.OEMarket.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccountController {
	
	private final MemberService memberService;
	
	// 회원가입
	@GetMapping(value ="/account/join.do" )
	public String AccountJoinForm(Model model) {
		model.addAttribute("memberForm", new MemberForm());
		return "account/join";
	}
	
	@PostMapping("/account/join.do")
	public String AccountJoin(@Validated MemberForm form, BindingResult result) {
		if(result.hasErrors()) {
			return "account/join";
		}
		memberService.createMember(form);
		
		return "redirect:/";
	}
	
	// 로그인
	@GetMapping(value ="/account/login.do" )
	public String AccountLogin() {
		return "account/login";
	}
	
	// 로그아웃
	@GetMapping("/account/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		
		return "redirect:/";
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

package com.OEMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.OEMarket.dto.MemberDTO;
import com.OEMarket.encryption.UserSha256;
import com.OEMarket.service.LoginService;
import com.OEMarket.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AccountController {

	@Autowired
	private MemberServiceImpl service;

	private final LoginService loginService;

	// 회원가입
	@GetMapping(value = "/account/join.do")
	public String AccountJoinForm() {
		return "account/join";
	}

	// 회원가입처리
	@PostMapping(value = "/account/join.do")
	public String JoinAction(MemberDTO memberDTO) {

		// 비밀번호 암호화
		String encryPassword = UserSha256.encrypt(memberDTO.getPassword());
		memberDTO.setPassword(encryPassword);

		service.registerMember(memberDTO);
		return "redirect:/";
	}

	// 로그인
	@GetMapping(value = "/account/login.do")
	public String AccountLoginForm() {
		return "account/login";
	}

	// 로그인 처리
	@PostMapping(value = "/account/login.do")
	public String loginAction(HttpSession session, MemberDTO memberDTO) {
		String returnURL = "/";
		if (session.getAttribute("loginmember") != null) {
			// 기존에 login이란 세션 값이 존재한다면 기존값 제거
			session.removeAttribute("loginmember");
		}
		// 로그인이 성공하면 MemberDTO 객체를 반환한다.
		service.loginMember(memberDTO);
		System.out.println(memberDTO);
		// 로그인 성공

		if (memberDTO != null) {
			// 세션에 login이라는 이름으로 memberdto 객체 저장
			session.setAttribute("loginmember", memberDTO);
			// 로그인 성공시 이동
			returnURL = "/";
		} else {
			// 로그인 실패
			returnURL = "redirect:/account/login";
		}
		return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// 비밀번호 찾기
	@GetMapping(value = "/account/find_pw.do")
	public String AccountFindPw() {
		return "account/find_pw";
	}

	// 아이디 찾기
	@GetMapping(value = "/account/find_id.do")
	public String AccountFindId() {
		return "account/find_id";
	}

	// 비밀번호 찾기 결과
	@GetMapping(value = "/account/find_pw_result.do")
	public String AccountFindPwResult() {
		return "account/find_pw_result";
	}

}

package com.OEMarket.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.OEMarket.dto.MemberDTO;
import com.OEMarket.encryption.UserSha256;
import com.OEMarket.service.MemberLoginService;
import com.OEMarket.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AccountController {

	@Autowired
	private MemberService memberService;

	@Inject
	private MemberLoginService memberLoginService;

	UserSha256 userSha256 = new UserSha256();

	// 회원가입
	@GetMapping(value = "/account/join.do")
	public String AccountJoinForm() {
		return "account/join";
	}

	// 회원가입처리
	@PostMapping(value = "/account/join.do")
	public String JoinAction(MemberDTO memberDTO) {

		// 비밀번호 암호화
		String encryPassword = userSha256.encrypt(memberDTO.getPassword());
		memberDTO.setPassword(encryPassword);

		memberService.registerMember(memberDTO);
		return "redirect:/";
	}

	// 로그인
	@GetMapping(value = "/account/login.do")
	public String AccountLoginForm(@ModelAttribute MemberDTO memberDTO) {
		return "account/login";
	}

	// 로그인 처리
	@PostMapping(value = "/account/login.do")
	public String loginCheck(MemberDTO memberDTO, HttpServletRequest req) {
		HttpSession session = req.getSession();

		String encryPassword = userSha256.encrypt(memberDTO.getPassword());
		memberDTO.setPassword(encryPassword);

		MemberDTO login = memberLoginService.loginCheck(memberDTO);

		if (login == null) {
			session.setAttribute("loginMember", null);
		} else {
			session.setAttribute("loginMember", login);
		}
		System.out.println("세션아이디 " + session.getAttribute("loginMember"));
		return "redirect:/";
	}

	// 로그아웃
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		memberLoginService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("account/login");
		mav.addObject("message", "logout");
		return mav;
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

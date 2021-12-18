package com.OEMarket.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.OEMarket.dto.MemberDTO;
import com.OEMarket.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberLoginController {

	private final MemberService memberService;

	@Autowired
	public MemberLoginController(MemberService memberService) {
		this.memberService = memberService;
	}

	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET(@ModelAttribute("memberDTO") MemberDTO memberDTO) {
		return "/member/login";
	}

	// 로그인 세션
	@PostMapping("/user/login")
	public String loginPOST(MemberDTO memberDTO, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		System.out.println(memberDTO.getEmail());
		Map<String, String> memberInform = memberService.login(memberDTO);
		System.out.println(memberInform);
		if (memberInform.get("email").equals(memberDTO.getEmail())
				&& memberInform.get("password").equals(memberDTO.getPassword())) {
			session.setAttribute("id", memberInform.get("id"));
			session.setAttribute("nickName", memberInform.get("nickName"));

			System.out.println("세션 생성");
			return "/member/loginSuccess";
		} else {
			System.out.println("로그인 실패");
			return "redirect:./";
		}
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		if (session.getAttribute("id") != null) {
			session.invalidate();
			return "/member/logout";
		} else {
			return "/member/denied";
		}
	}

}

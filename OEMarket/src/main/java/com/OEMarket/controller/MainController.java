package com.OEMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.OEMarket.dto.MemberDTO;
import com.OEMarket.session.SessionConstants;

/* 
 * 메인
 * 2021. 12. 14.
 * Jenny (secrethappy@naver.com)
 */

@Controller
public class MainController {
	// 인덱스
	@GetMapping(value ="index.do")
	public String mainControll(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) MemberDTO loginMember, Model model) {
		
		if(loginMember == null) {
			model.addAttribute("member", null);
			return "index";
		}
		
		model.addAttribute("member", loginMember);
		
		return "index";
	}
}

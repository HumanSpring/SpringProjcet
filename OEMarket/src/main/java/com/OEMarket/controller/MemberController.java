package com.OEMarket.controller;

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
public class MemberController {

	private final MemberService memberService;
	
	@GetMapping("/loginMember")
	public String createMemberForm(Model model) {
		model.addAttribute("memberForm", new MemberForm());
		return "member/login/register";
	}
	
	@PostMapping("/loginMember")
	public String createMember(@Validated MemberForm form, BindingResult result) {
		if(result.hasErrors()) {
			return "user/login/register";
		}
		memberService.createMember(form);
		
		return "redirect:/";
	}
	
}

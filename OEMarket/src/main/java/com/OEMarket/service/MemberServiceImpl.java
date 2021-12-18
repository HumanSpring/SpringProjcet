package com.OEMarket.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEMarket.dto.MemberDTO;
import com.OEMarket.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	// 로그인
	@Override
	public Map<String, String> login(MemberDTO memberDTO) throws Exception {
		return memberRepository.login(memberDTO);
	}

	// 회원가입
	@Override
	public void register(MemberDTO memberDTO) throws Exception {
		memberRepository.register(memberDTO);
	}

	@Override
	public int emailCheck(String email) throws Exception {
		int result = memberRepository.emailCheck(email);
		return result;
	}

	@Override
	public int nickCheck(String nickname) throws Exception {
		int result = memberRepository.nickCheck(nickname);
		return result;
	}

	@Override
	public int phoneCheck(String phone_number) throws Exception {
		int result = memberRepository.phoneCheck(phone_number);
		return result;
	}

	// 관리자
	@Override
	public List<Map<String, Object>> memberList(Integer member_page) {
		return memberRepository.memberList(member_page);
	}

	@Override
	public Double getTotal() {
		return memberRepository.getTotal();
	}

	@Override
	public int disableMember(Map<String, String> disable) {
		return memberRepository.disableMember(disable);
	}

}

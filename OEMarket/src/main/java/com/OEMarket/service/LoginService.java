package com.OEMarket.service;

import org.springframework.stereotype.Service;

import com.OEMarket.dto.MemberDTO;
import com.OEMarket.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginService {

	private final MemberRepository memberRepository;
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @return null이면 로그인 실패
	 */
	public MemberDTO login(String email, String password) {
		return memberRepository.findByEmail(email)
					.filter(m -> m.getPassword().equals(password))
					.orElse(null);
	}
	
}

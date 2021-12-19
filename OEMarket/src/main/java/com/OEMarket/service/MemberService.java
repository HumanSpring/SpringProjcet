package com.OEMarket.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.OEMarket.domain.Member;
import com.OEMarket.dto.MemberForm;
import com.OEMarket.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	@Transactional
	public Long createMember(MemberForm form) {
		Member member = form.toEntity();
		memberRepository.save(member);
		return member.getId();
	}
	
}

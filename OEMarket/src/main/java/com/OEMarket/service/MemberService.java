package com.OEMarket.service;

import com.OEMarket.dto.MemberDTO;

public interface MemberService {

	// 회원 가입
	public boolean registerMember(MemberDTO memberDTO);

}

package com.OEMarket.mapper;

import com.OEMarket.dto.MemberDTO;

public interface MemberMapper {

	// 회원 가입
	public void insertMember(MemberDTO memberDTO);
}

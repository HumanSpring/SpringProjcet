package com.OEMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.OEMarket.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	// 회원 가입
	public int insertMember(MemberDTO memberDTO);

	// 로그인
	public MemberDTO login(MemberDTO memberDTO);

}

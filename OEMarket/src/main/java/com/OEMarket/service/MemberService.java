package com.OEMarket.service;

import java.util.List;
import java.util.Map;

import com.OEMarket.dto.MemberDTO;

public interface MemberService {

	// 가입
	void register(MemberDTO memberDTO) throws Exception;

	int emailCheck(String email) throws Exception;

	int nickCheck(String nickName) throws Exception;

	int phoneCheck(String phone) throws Exception;

	// 로그인
	Map<String, String> login(MemberDTO memberDTO) throws Exception;

	// 관리자
	List<Map<String, Object>> memberList(Integer member_page);

	Double getTotal();

	int disableMember(Map<String, String> disable);

}

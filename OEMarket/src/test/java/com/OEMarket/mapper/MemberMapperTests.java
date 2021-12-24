package com.OEMarket.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.OEMarket.dto.MemberDTO;

@SpringBootTest
class MemberMapperTests {

	@Autowired
	private MemberMapper membermapper;

	@Test
	@DisplayName("회원가입 테스트")
	public void insertMemberTest() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setEmail("ronaldo@naver.com");
		memberDTO.setPassword("asdf1234");
		memberDTO.setName("호나우딩요");
		memberDTO.setNickname("축구의신");
		memberDTO.setGender("M");
		memberDTO.setPhone("01012345678");
		memberDTO.setUserIcon("호날두사진");
//		memberDTO.setMember_role("USER");

		membermapper.insertMember(memberDTO);
	}

//	@Test
//	@DisplayName("로그인 테스트")
//	public void loginMemeberTest() {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setEmail("messi@naver.com");
//		memberDTO.setPassword("1234");
//		String encryPassword = UserSha256.encrypt(memberDTO.getPassword());
//		memberDTO.setPassword(encryPassword);
//
//		membermapper.login(memberDTO);
//	}

}

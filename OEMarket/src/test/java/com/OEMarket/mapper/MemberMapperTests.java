package com.OEMarket.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.OEMarket.dto.MemberDTO;

@SpringBootTest
class MemberMapperTests {

	@Autowired
	private MemberMapper membermapper;

	@Test
	public void insertMemberTest() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setEmail("ronaldo@naver.com");
		memberDTO.setPassword("asdf1234");
		memberDTO.setName("호나우딩요");
		memberDTO.setNickname("축구의신");
		memberDTO.setGender("M");
		memberDTO.setPhone("01012345678");
		memberDTO.setUserIcon("호날두사진");
		memberDTO.setMemberRole("USER");

		membermapper.insertMember(memberDTO);
	}

	public void loginMemeberTest() {

	}

}

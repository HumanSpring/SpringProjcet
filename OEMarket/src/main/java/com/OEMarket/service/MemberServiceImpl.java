package com.OEMarket.service;

import javax.inject.Inject;

import com.OEMarket.dao.MemberDAO;
import com.OEMarket.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO memberDAO;

	@Override
	public void memberRegister(MemberDTO memberDTO) {

		System.out.println("회원 가입 동작");
		if (memberDTO == null) {

			return;
		}

		memberDAO.memberRegister(memberDTO);
	}

}

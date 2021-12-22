package com.OEMarket.service;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEMarket.dto.MemberDTO;
import com.OEMarket.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Inject
	private SqlSession session;

	@Override
	public boolean registerMember(MemberDTO memberDTO) {

		int queryResult = 0;
		if (memberDTO.getUserNo() == null) {
			queryResult = memberMapper.insertMember(memberDTO);
		} else {
			queryResult = 0;
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public MemberDTO login(MemberDTO memberDTO) {

		return session.selectOne("member.login", memberDTO);
	}

}

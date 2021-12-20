package com.OEMarket.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.OEMarket.dto.MemberDTO;

public class MemberDAOImple implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.OEMarket.mapper.MemberMapper";

	@Override
	public void memberRegister(MemberDTO memberDTO) {
		System.out.println("================");
		sqlSession.insert(namespace + ".insertMember", memberDTO);

	}

}

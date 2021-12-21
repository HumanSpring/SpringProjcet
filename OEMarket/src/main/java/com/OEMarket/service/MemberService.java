package com.OEMarket.service;

import com.OEMarket.dto.MemberDTO;

public interface MemberService {

	public boolean registerMember(MemberDTO memberDTO);

	public MemberDTO loginMember(MemberDTO memberDTO);

}

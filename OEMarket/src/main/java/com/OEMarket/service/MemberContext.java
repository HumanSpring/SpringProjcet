package com.OEMarket.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.OEMarket.domain.Member;

@SuppressWarnings("serial")
public class MemberContext extends User {

	private final Member member;
	
	public MemberContext(Member member, Collection<? extends GrantedAuthority> authorities) {
		super(member.getEmail(), member.getPassword(), authorities);
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}

	
	
}

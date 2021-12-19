package com.OEMarket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.OEMarket.domain.Member;
import com.OEMarket.repository.MemberRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(memberEmail);
		
		if(member == null) {
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}
		
		// TODO => 권한과 관련된 내용
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(member.getMemberRole()));
		// end
		
		MemberContext memberContext = new MemberContext(member, roles);
		
		return memberContext;
		
	}

}

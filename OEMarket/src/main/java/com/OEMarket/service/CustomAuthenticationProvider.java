package com.OEMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userEmail = authentication.getName();
		String password = (String)authentication.getCredentials();
		
		MemberContext memberContext = (MemberContext) userDetailsService.loadUserByUsername(userEmail);
		
		if(!passwordEncoder.matches(password, memberContext.getMember().getPassword())) {
			throw new BadCredentialsException("BadCredentialsException");
		}
		
		// 세션? 권한? 로그인이후에 권한을 준다.
		UsernamePasswordAuthenticationToken authenticationToken
			= new UsernamePasswordAuthenticationToken(memberContext.getMember(), 
					null, 
					memberContext.getAuthorities());
		
		return authenticationToken;
	}

	// 세션? 권한? 로그인이후에 권한을 준다.
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
}

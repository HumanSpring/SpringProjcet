package com.OEMarket.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.OEMarket.domain.Member;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberForm {

	private Long id;
	private String email;
	private String password;
	private String name;
	private String nickname;
	private String gender;
	private String phone;
	private String userIcon;
	private String memberRole;
	
	@Builder
	public MemberForm(Long id, String email, String password, String name, String nickname, String gender, String phone, String userIcon, String memberRole) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.phone = phone;
		this.userIcon = userIcon;
		this.memberRole = memberRole;
	}
	
	public Member toEntity() {
		return Member.builder()
				.id(id)
				.email(email)
				.password(new BCryptPasswordEncoder().encode(password))
				.name(name)
				.nickname(nickname)
				.gender(gender)
				.phone(phone)
				.userIcon(userIcon)
				.build();
	}
	
}

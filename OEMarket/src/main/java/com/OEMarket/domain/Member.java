package com.OEMarket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "MEMBER")
// 다른 패키지에서 생성자 함부로 생성하지 마세요!
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(name = "member_id_gen", sequenceName = "member_id_seq", initialValue = 1, allocationSize = 1)
public class Member {

	@Id
	@Column(name = "\"id\"", columnDefinition = "number default member_id_seq.nextval")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_id_gen")
	private Long id;
	
	@Column(name = "\"email\"")
	private String email;
	
	@Column(name = "\"password\"")
	private String password;
	
	@Column(name = "\"name\"")
	private String name;
	
	@Column(name = "\"nickname\"")
	private String nickname;
	
	@Column(name = "\"gender\"")
	private String gender;
	
	@Column(name = "\"phone\"")
	private String phone;
	
	@Column(name = "\"user_icon\"")
	private String userIcon;
	
	@Column(name = "\"member_role\"")
	private String memberRole = "ROLE_USER";
	
	@Builder
	public Member(Long id, String email, String password, String name, String nickname, String gender, String phone, String userIcon) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.phone = phone;
		this.userIcon = userIcon;
	}
	
}

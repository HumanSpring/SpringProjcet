package com.OEMarket.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member")
public class MemberEntity {

	/* 회원 번호(PK) */
	private Long id;

	/* 아이디 */
	private String email;

	/* 비밀번호 */
	private String password;

	/* 이름 */
	private String name;

	/* 닉네임 */
	private String nickName;

	/* 성별 */
	private String gender;

	/* 전화번호 */
	private String phone;

	/* 회원아이콘 */
	private String user_Icon;

	/* 회원구분 */
	private String member_Role;

	/* 회원탈퇴여부 */
	private String signout_Yn;

	/* 회원가입날짜 */
	private LocalDateTime signup_Date;

	/* 회원탈퇴날짜 */
	private Date signout_Date;

	@Builder
	public MemberEntity(Long id, String email, String password, String name, String nickName, String gender,
			String phone, String user_Icon, String member_Role, String signout_Yn) {

		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
		this.gender = gender;
		this.phone = phone;
		this.user_Icon = user_Icon;
		this.member_Role = member_Role;
		this.signout_Yn = signout_Yn;
	}

	@PrePersist
	public void signDate() {
		this.signup_Date = LocalDateTime.now();
	}
}

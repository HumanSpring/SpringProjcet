package com.OEMarket.dto;

import lombok.Data;

@Data
public class MemberDTO {

	/* 회원번호 */
	private Long userNo;

	/* 이메일 */
	private String email;

	/* 비밀번호 */
	private String password;

	/* 이름 */
	private String name;

	/* 닉네임 */
	private String nickname;

	/* 성별 */
	private String gender;

	/* 전화번호 */
	private String phone;

	/* 회원 아이콘 */
	private String userIcon;

	/* 회원 가입일 */
	private String signup_date;

	/* 회원 탈퇴여부 */
	private String signout_yn;

	/* 회원 탈퇴일 */
	private String signout_date;

	/* 회원 구분 */
	private String memberRole;

}

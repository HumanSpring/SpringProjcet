package com.OEMarket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	/* 회원 번호(PK) */
	private Long userNo;
	
	/* 아이디 */
	private String id;
	
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
	private String userIconName;
	
	/* 회원가입날짜 */
	private String signupDate;
	
	/* 회원탈퇴여부 */
	private String signoutYn;
	
	/* 회원탈퇴날짜 */
	private String signoutDate;
	
	/* 관리자 */
	private String manager;
	
}

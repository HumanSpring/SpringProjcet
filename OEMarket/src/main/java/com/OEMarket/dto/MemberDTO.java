package com.OEMarket.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.OEMarket.constant.MemberRole;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "member")
public class MemberDTO {

	/* 회원 번호(PK) */
	@Id
	@GeneratedValue
	private Long userNo;

	/* 아이디 */
	@Column(nullable = false, unique = true, length = 50)
	private String id;

	/* 비밀번호 */
	@Column(nullable = false, length = 16)
	private String password;

	/* 이름 */
	@Column(nullable = false, length = 10)
	private String name;

	/* 닉네임 */
	@Column(nullable = false, length = 20)
	private String nickName;

	/* 성별 */
	@Column(nullable = false, length = 1)
	private String gender;

	/* 전화번호 */
	@Column(nullable = false, length = 11)
	private String phone;

	/* 회원아이콘 */
	@Column(nullable = false)
	private String userIconName;

	/* 회원가입날짜 */
	@Column(nullable = false)
	@CreationTimestamp // Insert 시 자동으로 값을 채워줌
	private Date signupDate;

	/* 회원탈퇴여부 */
	@Column(nullable = false, length = 1)
	private String signoutYn;

	/* 회원탈퇴날짜 */
	@UpdateTimestamp // Update 시 자동으로 값을 채워줌
	private Date signoutDate;

	/* member 구분(관리자, 일반회원) */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private MemberRole memberRole;

}

package com.OEMarket.dto;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserKeyWordDTO extends CommonDTO {
	
	/* 키워드 */
	private String keyword;
	
	/* 회원번호 */
	private Long userNo;
	
	/* 키워드 + 회원번호 (PK) */
	

}

package com.OEMarket.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 2021-12-10
 * 공통컬럼을 묶기 위한 클래스 
 * @author 강경모
 */
@Getter
@Setter
public class CommonDTO {
	
	/* 등록일 */
	private Date writeDate;
	
	/* 수정자 */
	private String modifier;
	
	/* 수정일 */
	private Date modifyDate;
	
}

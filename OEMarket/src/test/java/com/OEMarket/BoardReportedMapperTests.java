package com.OEMarket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.OEMarket.dto.ReportedDTO;
import com.OEMarket.mapper.BoardReportedMapper;

@SpringBootTest
public class BoardReportedMapperTests {
	@Autowired
	private BoardReportedMapper boardReportedMapper;

	@Test
//	글 작성
	public void testOfInsert() {
		ReportedDTO params = new ReportedDTO();
		params.setReportedNo((long) 1);
		params.setBoardNo((long) 1);
		params.setCommentNo((long) 1);
		params.setUserNo((long) 1);
		params.setContent("27번 게시글 내용");

		int result = boardReportedMapper.insertBoardReported(params);
		System.out.println("결과는 " + result + "입니다.");
	}
	
	
	
}

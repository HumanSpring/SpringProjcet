package com.OEMarket;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.OEMarket.dto.BoardDTO;
import com.OEMarket.dto.ReportedDTO;
import com.OEMarket.mapper.BoardMapper;
import com.OEMarket.mapper.BoardReportedMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

package com.OEMarket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.OEMarket.dto.BoardDTO;
import com.OEMarket.mapper.BoardMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class MapperTests {
	@Autowired
	private BoardMapper boardMapper;

	@Test
//	글 작성
	public void testOfInsert() {
		BoardDTO params = new BoardDTO();
		params.setUserNo((long) 1);
		params.setTitle("3번 게시글 제목");
		params.setCategoryNo((long) 1);
		params.setPrice(20000);
		params.setContent("3번 게시글 내용");

		int result = boardMapper.insertBoard(params);
		System.out.println("결과는 " + result + "입니다.");
	}
	
	@Test
//	수정
	public void testOfUpdate() {
		BoardDTO params = new BoardDTO();
		params.setBoardNo((long)23);
		params.setTitle("2번 게시글 제목을 수정합니다");
		params.setPrice(40000);
		params.setContent("2번 게시글 내용");
		params.setModifier("김루나");
		params.setNoticeYn("1");

		int result = boardMapper.updateBoard(params);
		if (result == 1) {
			BoardDTO board = boardMapper.selectBoardDetail((long) 1);
			try {
				String boardJson = new ObjectMapper().writeValueAsString(board);

				System.out.println("=========================");
				System.out.println(boardJson);
				System.out.println("=========================");

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}

package com.OEMarket;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

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
		params.setTitle("290번 게시글 제목");
		params.setCategoryNo((long)21);
		params.setPrice(50000);
		params.setContent("27번 게시글 내용");

		int result = boardMapper.insertBoard(params);
		System.out.println("결과는 " + result + "입니다.");
	}
	
	@Test
	//조회
	public void testOfSelectDetail() {
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
	
	@Test
//	수정
	public void testOfUpdate() {
		BoardDTO params = new BoardDTO();
		params.setBoardNo((long)41);
		params.setTitle("해당 게시글 제목을 수정합니다");
		params.setPrice(40000);
		params.setContent("41번 게시글 내용");
		params.setModifier("꼬마");
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
	
	@Test
	//삭제
	public void testOfDelete() {
		int result = boardMapper.deleteBoard((long) 1);
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
	
	@Test
//	50개 추가
	public void testMultipleInsert() {
		for (int i = 2; i <= 50; i++) {
			BoardDTO params = new BoardDTO();
			params.setUserNo((long) 1);
			params.setTitle("27번 게시글 제목");
			params.setCategoryNo((long) 1);
			params.setPrice(50000);
			params.setContent("27번 게시글 내용");
			params.setNoticeYn("0");
			boardMapper.insertBoard(params);
		}
	}
	
	@Test
//	삭제되지 않은 게시물 조회
	public void testSelectList() {
		int boardTotalCount = boardMapper.selectBoardTotalCount();
		if (boardTotalCount > 0) {
			List<BoardDTO> boardList = boardMapper.selectBoardList();
			if (CollectionUtils.isEmpty(boardList) == false) {
				for (BoardDTO board : boardList) {
					System.out.println("=========================");
					System.out.println(board.getUserNo());
					System.out.println(board.getTitle());
					System.out.println(board.getCategoryNo());
					System.out.println(board.getPrice());
					System.out.println(board.getContent());
					System.out.println(board.getNoticeYn());
					System.out.println("=========================");
				}
			}
		}
	}
	
	
}

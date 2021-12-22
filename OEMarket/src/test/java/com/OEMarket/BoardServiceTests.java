package com.OEMarket;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.OEMarket.dto.BoardDTO;
import com.OEMarket.service.BoardService;

@SpringBootTest
public class BoardServiceTests {

	@Autowired
	private BoardService boardService;
	
	@Test
	public void testByGetBoardList() {
		List<BoardDTO> boardList = boardService.getBoardList();
		
		System.out.println(boardList);
	}
	
	@Test
	public void testByBoardDetail() {
		BoardDTO board = boardService.getBoardDetail((long) 136);
		
		System.out.println(board.getTitle());
	}
	
}

package com.OEMarket;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.OEMarket.dto.CommentDTO;
import com.OEMarket.service.CommentService;

@SpringBootTest
public class CommentServiceTests {

	@Autowired
	private CommentService commentService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void testByRegisterComment() {
		
	}
	
	/* deleteComment 테스트 2021-12-13 완료 */
	@Test
	public void testByDeleteComment() {
		commentService.deleteComment((long) 30);
		testByGetCommentList();
	}
	
	/* getCommentList 테스트 2021-12-13 완료 */
	@Test
	public void testByGetCommentList() {
		CommentDTO params = new CommentDTO();
		params.setBoardNo((long) 1);
		
		commentService.getCommentList(params);
	}
	
}

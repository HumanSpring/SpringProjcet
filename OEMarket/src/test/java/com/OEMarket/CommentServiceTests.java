package com.OEMarket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.OEMarket.dto.CommentDTO;
import com.OEMarket.mapper.CommentMapper;
import com.OEMarket.service.CommentService;

@SpringBootTest
public class CommentServiceTests {

	@Autowired
	private CommentService commentService;

	@Autowired
	private CommentMapper commentMapper;
	
	@Test
	public void testByRegisterComment() {
//		CommentDTO params = new CommentDTO();
		CommentDTO comment = commentMapper.selectCommentDetail((long) 50);
		
		/* 댓글 등록 테스트 2021-12-14 완료 */
//		params.setBoardNo((long) 1);
//		params.setUserNo((long) 2);
//		params.setContent("service에서 등록한 댓글");
		
		/* 댓글 수정 테스트 2021-12-14 완료 */
//		comment.setContent("service 수정 댓글");
//		comment.setModifier("강경모");
		
		/* 대댓글 등록 테스트 2021-12-14 완료 */
//		params.setBoardNo((long) 1);
//		params.setUserNo((long) 2);
//		params.setContent("service에서 등록한 대댓글2");
//		params.setParent((long) 42);
//		params.setDepth(2);
		
		/* 대댓글 수정 테스트 */
		comment.setContent("service 수정 대댓글");
		comment.setModifier("강경모");
		
//		boolean result = commentService.registerComment(params);
		boolean result = commentService.registerComment(comment);
		System.out.println("결과는 : " + result);
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

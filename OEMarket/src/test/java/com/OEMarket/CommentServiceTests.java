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

		CommentDTO comment = commentMapper.selectCommentDetail((long) 157);
		comment.setModifier("testnickname01");
		comment.setContent("157번 댓글을 수정합니다.");

		boolean result = commentService.registerComment(comment);
		System.out.println("결과는 : " + result + "입니다.");

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

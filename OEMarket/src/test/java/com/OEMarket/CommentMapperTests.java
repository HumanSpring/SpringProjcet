package com.OEMarket;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.OEMarket.dto.CommentDTO;
import com.OEMarket.mapper.CommentMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class CommentMapperTests {

	@Autowired
	private CommentMapper commentMapper;
	
	// TODO => 현재는 대댓글이 아닌 댓글만 insert가능
	@Test
	public void testByInsertComment() {
		CommentDTO params = new CommentDTO();
		params.setBoardNo((long) 1);
		params.setUserNo((long) 1);
		params.setContent("mapper에서 입력한 댓글 내용");
		params.setDepth(1);
		
		int result = commentMapper.insertComment(params);
		
		System.out.println("결과는 : "+result);
	}
	
	/* selectCommentDetail 테스트 2021-12-13 완료 */
	@Test
	public void testBySelectCommentDetail() {
		CommentDTO comment = commentMapper.selectCommentDetail((long) 1);
		
		try {
			String commentJson = new ObjectMapper().writeValueAsString(comment);
			
			System.out.println("===============================");
			System.out.println(commentJson);
			System.out.println("===============================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* updateComment 테스트 2021-12-13 완료 */
	@Test
	public void testByUpdateComment() {
		CommentDTO params = new CommentDTO();
		params.setContent("2번 댓글을 수정합니다.");
		params.setModifier("mapper modifier");
		params.setCommentNo((long) 2);
		
		int result = commentMapper.updateComment(params);
		
		if(result == 1) {
			CommentDTO comment = commentMapper.selectCommentDetail((long) 2);
			
			try {
				String commentJson = new ObjectMapper().writeValueAsString(comment);
				
				System.out.println("===========================================");
				System.out.println(commentJson);
				System.out.println("===========================================");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/* deleteComment 테스트 2021-12-13 완료 */
	@Test
	public void testByDeleteComment() {
		int result = commentMapper.deleteComment((long) 2);
		
		if(result == 1) {
			CommentDTO comment = commentMapper.selectCommentDetail((long) 2);
			
			try {
				String commentJson = new ObjectMapper().writeValueAsString(comment);
				
				System.out.println("==================================================");
				System.out.println(commentJson);
				System.out.println("==================================================");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/* selectCommentList 테스트 2021-12-13 완료 */
	@Test
	public void testBySelectCommentList() {
		CommentDTO comment = commentMapper.selectCommentDetail((long) 1);
		int totalCountComment = commentMapper.selectCommentTotalCount(comment);
		
		if(totalCountComment > 0) {
			List<CommentDTO> commentList = commentMapper.selectCommentList(comment);
			if(CollectionUtils.isEmpty(commentList) == false) {
				for (CommentDTO commentDTO : commentList) {
					String commentJson;
					try {
						commentJson = new ObjectMapper().writeValueAsString(commentDTO);
						
						System.out.println("==================================================================================================================================");
						System.out.println(commentJson);
						System.out.println("==================================================================================================================================");
						System.out.println();
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/* selectCommentTotalCount 테스트 2021-12-13 완료 */
	@Test
	public void testBySelectCommentTotalCount() {
		CommentDTO comment = commentMapper.selectCommentDetail((long) 1);
		int totalCountComment = commentMapper.selectCommentTotalCount(comment);
		
		System.out.println(totalCountComment);
	}
	
}

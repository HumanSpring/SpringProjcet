package com.OEMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.OEMarket.dto.CommentDTO;

/**
 * @author 강경모
 * 2021-12-13 작성
 */
@Mapper
public interface CommentMapper {

	// TODO -> 현재는 대댓글이 아닌 댓글만 insert가능 2021-12-13
	public int insertComment(CommentDTO params);
	
	public CommentDTO selectCommentDetail(Long idx);

	// TODO -> 회원기능과 합쳐지면 modifier가 로그인한 회원이 입력될수 있게끔 수정 예정 2021-12-13
	public int updateComment(CommentDTO params);
	
	// TODO -> 회원기능과 합쳐지면 modifier가 로그인한 회원이 입력될수 있게끔 수정 예정 2021-12-13
	public int deleteComment(Long idx);
	
	public List<CommentDTO> selectCommentList(CommentDTO params);
	
	public int selectCommentTotalCount(CommentDTO params);
	
}

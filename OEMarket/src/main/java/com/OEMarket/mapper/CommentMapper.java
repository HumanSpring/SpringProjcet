package com.OEMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.OEMarket.dto.CommentDTO;

@Mapper
public interface CommentMapper {

	// TODO -> 현재는 대댓글이 아닌 댓글만 insert가능
	public int insertComment(CommentDTO params);
	
	public CommentDTO selectCommentDetail(Long idx);

	// TODO -> 회원기능과 합쳐지면 modifier가 입력될수 있게끔 수정
	public int updateComment(CommentDTO params);
	
	// TODO -> 회원기능과 합쳐지면 modifier가 입력될수 있게끔 수정
	public int deleteComment(Long idx);
	
	// TODO -> 대댓글이 있는 삭제된 댓글은 표시하고 대댓글이 있지 않은 삭제된 댓글은 표시안해주기
	public List<CommentDTO> selectCommentList(CommentDTO params);
	
	public int selectCommentTotalCount(CommentDTO params);
	
}

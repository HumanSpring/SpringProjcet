package com.OEMarket.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEMarket.dto.CommentDTO;
import com.OEMarket.mapper.CommentMapper;

/** 
 * @author 강경모
 * 2021-12-13
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public boolean registerComment(CommentDTO params) {
		
		int result = 0;
		
		//  parent가 null이면 부모댓글 없음 -> 댓글로 입력, null이 아니면 부모댓글이 있음 -> 대댓글로 입력
		boolean isRoot = params.getParent() == null;
		
		if(isRoot) {
			if(params.getCommentNo() == null) {
				result = commentMapper.insertComment(params);
			} else {
				result = commentMapper.updateComment(params);
			}
		} else {
			if(params.getCommentNo() == null) {
				result = commentMapper.insertReplyComment(params);
			} else {
				result = commentMapper.updateComment(params);
			}
		}
		
		return (result == 1) ? true : false;
	}

	@Override
	public boolean deleteComment(Long idx) {
		int queryResult = 0;

		CommentDTO comment = commentMapper.selectCommentDetail(idx);

		// 0 = false, 1 = true
		if (comment != null && "0".equals(comment.getDeleteYn())) {
			queryResult = commentMapper.deleteComment(idx);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<CommentDTO> getCommentList(CommentDTO params) {
		List<CommentDTO> commentList = Collections.emptyList();

		int commentTotalCount = commentMapper.selectCommentTotalCount(params);
		
		if (commentTotalCount > 0) {
			commentList = commentMapper.selectCommentList(params);
		}
		return commentList;
	}

}

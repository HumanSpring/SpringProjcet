package com.OEMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.OEMarket.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	public int insertBoard(BoardDTO params);

	public BoardDTO selectBoardDetail(Long boardNo);

	public int updateBoard(BoardDTO params);

	public int deleteBoard(Long boardNo);

	public List<BoardDTO> selectBoardList();

	public int selectBoardTotalCount();
}





package com.OEMarket.mapper;

import java.util.List;

import com.OEMarket.dto.BoardDTO;

public interface NoticeMapper {
	public int insertNotice(BoardDTO params);

	public BoardDTO selectNoticeDetail(Long boardNo);

	public int updateNotice(BoardDTO params);

	public int deleteNotice(Long boardNo);

	public List<BoardDTO> selectNoticeList();

	public int selectNoticeTotalCount();

}

package com.OEMarket.service;

import java.util.List;

import com.OEMarket.dto.BoardDTO;

public interface NoticeService {
	public boolean registerNotice(BoardDTO params);

	public BoardDTO getNoticeDetail(Long boardNo);

	public boolean deleteNotice(Long boardNo);

	public List<BoardDTO> getNoticeList();
}

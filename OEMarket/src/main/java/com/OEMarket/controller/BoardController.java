package com.OEMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.OEMarket.dto.BoardDTO;
import com.OEMarket.service.BoardService;


@Controller // 사용자의 요청과 응답을 처리, UI를 담당하는 컨트롤러 클래스
public class BoardController {
	@Autowired
	private BoardService boardService;

	// 쓰기
	@GetMapping(value = "/board/write.do")
	public String openBoardWrite(@RequestParam(value = "boardNo", required = false) Long boardNo, Model model) {
		if (boardNo == null) {
			model.addAttribute("board", new BoardDTO());
		} else {
			BoardDTO board = boardService.getBoardDetail(boardNo);
			if (board == null) {
				return "redirect:/board/list.do";
			}
			model.addAttribute("board", board);
		}

		return "board/write";
	}
	
	// 게시글 등록
	@PostMapping(value = "/board/register.do")
	public String registerBoard(final BoardDTO params) {
		try {
			boolean isRegistered = boardService.registerBoard(params);
			if (isRegistered == false) {
				// TODO => 게시글 등록에 실패하였다는 메시지를 전달
			}
		} catch (DataAccessException e) {
			// TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달

		} catch (Exception e) {
			// TODO => 시스템에 문제가 발생하였다는 메시지를 전달
		}

		return "redirect:/board/list.do";
	}
	
}

package com.OEMarket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.OEMarket.dto.UserKeyWordDTO;
import com.OEMarket.service.UserKeyWordService;

@Controller
public class UserKeyWordController {
	@Autowired
	private UserKeyWordService userKeyWordService;

	@RequestMapping(value = "/KeyWord/view.do", method = RequestMethod.GET)
	public String keywordinsert(final UserKeyWordDTO params, HttpServletRequest request) {
		HttpSession session = request.getSession();
		/* int userNo = (int) session.getAttribute("UserNo"); */
		
		try {
			boolean register = userKeyWordService.registerUserKeyWord(params);
			if (register == false) {
				System.out.println("키워드 등록 실패");				
			}
		}catch (DataAccessException e) {
				System.out.println("데이터 처리과정");
				System.out.println(e);
			}	
		return "/KeyWord/view";
}
	
	@RequestMapping(value = "/KeyWord/select.do")
	public String openUserKeyWordList(Model model) {
		List<UserKeyWordDTO> keywordList = userKeyWordService.getUserKeyWordList();
		model.addAttribute("keywordList", keywordList);
		
		return "KeyWord/select";
		
	}
}

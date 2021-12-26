package com.OEMarket.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEMarket.dto.UserKeyWordDTO;
import com.OEMarket.mapper.UserKeyWordMapper;

@Service
public class UserKeyWordServiceImpl implements UserKeyWordService {
	
	@Autowired
	private UserKeyWordMapper userKeyWordMapper;
	
	@Override
	public boolean registerUserKeyWord(UserKeyWordDTO params) {
		int queryResult = 0;
		
		if(params.getKeyword() != null) {
			queryResult = userKeyWordMapper.insertUserKeyWord(params);
		}		
		return (queryResult == 1) ? true : false;
}

	
	@Override
	public List<UserKeyWordDTO> getUserKeyWordList() {
		List<UserKeyWordDTO> userKeyWordList = Collections.emptyList();
		
		return userKeyWordList;
		
	}
}
package com.OEMarket.service;

import java.util.List;


import com.OEMarket.dto.UserKeyWordDTO;

public interface UserKeyWordService {
	
	
	
	public boolean registerUserKeyWord(UserKeyWordDTO params);
	
	public List<UserKeyWordDTO> getUserKeyWordList();	

	
	
	
}
package com.OEMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.OEMarket.dto.BoardDTO;
import com.OEMarket.dto.UserKeyWordDTO;

public interface UserKeyWordMapper {


	public int insertUserKeyWord(UserKeyWordDTO params);
	
	public List<UserKeyWordDTO> selectUserKeyWordList();
	

}
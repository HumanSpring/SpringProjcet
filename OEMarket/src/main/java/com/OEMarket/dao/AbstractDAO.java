package com.OEMarket.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {

	private static final Logger logger = LoggerFactory.getLogger(AbstractDAO.class);

	@Autowired
	private SqlSession sqlSession;

	public void printQueryId(String queryId) {
		logger.info("[ Execute QueryId ] ::: " + queryId);
	}

}

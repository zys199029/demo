package com.cogitationsoft.findit.service.impl;

import com.cogitationsoft.findit.mapper.DemoMapper;
import com.cogitationsoft.findit.pojo.DemoDO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Andy
 * @date: 5/4/2018 9:50 AM
 * @description: 样例Service
 * @version: 1.0
 */
@Service
public class DemoServiceImpl {
	@Autowired(required = false)
	private DemoMapper mapper;

	private static final Logger logger = LogManager.getLogger(DemoServiceImpl.class);
	@Transactional(rollbackFor = Exception.class)
	public void insert(){
		int id = (int)(Math.random() * 100000);
		DemoDO demoDO = new DemoDO(id, 23, "wanghaoxin");
		logger.error("开始执行插入Demo的信息！");

		mapper.insert(demoDO);
	}

}

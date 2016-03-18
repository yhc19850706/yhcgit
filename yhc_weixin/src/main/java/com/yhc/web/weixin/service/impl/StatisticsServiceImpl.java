package com.yhc.web.weixin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhc.common.mapper.StatisticsMapper;
import com.yhc.web.weixin.service.StatisticsService;
import com.yhc.weixin.model.WxStatistics;

@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private StatisticsMapper statisticsMapper;
	
	@Override
	public void insertWxStatistics(WxStatistics wxStatistics) throws Exception {
		statisticsMapper.insertWxStatistics(wxStatistics);
	}
}

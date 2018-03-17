package com.yhc.lifeall.service.impl;

import com.yhc.lifeall.mapper.netcrawl.ExpressLogisticsMapper;
import com.yhc.lifeall.model.netcrawl.ExpressLogistics;
import com.yhc.lifeall.model.netcrawl.ExpressLogisticsExample;
import com.yhc.lifeall.service.ExpressLogisticsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressLogisticsServiceImpl implements ExpressLogisticsService {
    @Autowired
    ExpressLogisticsMapper expressLogisticsMapper;
    @Override
    public List<ExpressLogistics> search(String code, String kdcode) {
        ExpressLogisticsExample expressLogisticsExample=new ExpressLogisticsExample();
        ExpressLogisticsExample.Criteria criteria=expressLogisticsExample.createCriteria();
        criteria.andExpressCodeEqualTo(code);
        if (StringUtils.isNotBlank(kdcode)) {
            criteria.andExpressTypeEqualTo(kdcode);
        }
        expressLogisticsExample.setOrderByClause("node_time desc");
        List<ExpressLogistics> expressLogistics=expressLogisticsMapper.selectByExample(expressLogisticsExample);
        return expressLogistics;
    }

    @Override
    public void createExpressLogistics(List<ExpressLogistics> expressLogisticsList) {
        ExpressLogistics expressLogistics=expressLogisticsList.get(0);
        ExpressLogisticsExample expressLogisticsExample=new ExpressLogisticsExample();
        ExpressLogisticsExample.Criteria criteria=expressLogisticsExample.createCriteria();
        criteria.andExpressCodeEqualTo(expressLogistics.getExpressCode());
        criteria.andExpressTypeEqualTo(expressLogistics.getExpressType());
        List<ExpressLogistics> list=expressLogisticsMapper.selectByExample(expressLogisticsExample);
        if(list!=null&&list.size()>0 &&list.size()<expressLogisticsList.size()){
            expressLogisticsMapper.deleteByExample(expressLogisticsExample);
        }
        if(list==null||list.size()<expressLogisticsList.size()){
            for (ExpressLogistics logistics : expressLogisticsList) {
                expressLogisticsMapper.insertSelective(logistics);
            }
        }
    }
}

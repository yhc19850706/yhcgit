package com.yhc.lifeall.service;

import com.yhc.lifeall.model.ExpressLogistics;

import java.util.List;

public interface ExpressLogisticsService {
    List<ExpressLogistics> search(String code,String kdcode);
    void createExpressLogistics(List<ExpressLogistics> expressLogistics);
}

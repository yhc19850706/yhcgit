package com.yhc.lifeall.service;

import com.yhc.lifeall.model.netcrawl.NewsContent;

import java.util.List;

public interface NewsContentService {
    List<NewsContent> findAll(int pageNum, int pageSize,long website_id);
}

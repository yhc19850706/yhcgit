package com.yhc.lifeall.service.impl;

import com.github.pagehelper.PageHelper;
import com.yhc.lifeall.mapper.NewsContentMapper;
import com.yhc.lifeall.model.NewsContent;
import com.yhc.lifeall.model.NewsContentExample;
import com.yhc.lifeall.service.NewsContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsContentServiceImpl implements NewsContentService {
    @Autowired
    NewsContentMapper newsContentMapper;

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */

    public List<NewsContent> findAll(int pageNum, int pageSize,long websiteid) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        NewsContentExample newsContentExample= new NewsContentExample();
        NewsContentExample.Criteria criteria=newsContentExample.createCriteria();
        criteria.andWebsiteIdEqualTo(websiteid);
        newsContentExample.setOrderByClause("publish_time desc");
        return newsContentMapper.selectByExampleWithBLOBs(newsContentExample);
    }
}

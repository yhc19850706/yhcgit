package com.yhc.lifeall.task;

import com.yhc.lifeall.common.utils.MylogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Component
public class CrawlDataTask {

    @Autowired
    private RestTemplate restTemplate;

    //每天早上8：15触发
    //@Scheduled(fixedRate = 30000)
    public void crawlCctv2(){
        ResponseEntity<Map> responseEntity=restTemplate.getForEntity("http://127.0.0.1:5000/yhc/api/crawlcctv",Map.class);
        MylogUtil.i(responseEntity.getBody().toString());
    }
}

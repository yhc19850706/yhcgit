package com.yhc.lifeall.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.yhc.lifeall.model.netcrawl.ExpressLogistics;
import com.yhc.lifeall.model.netcrawl.NewsContent;
import com.yhc.lifeall.service.ExpressLogisticsService;
import com.yhc.lifeall.service.NewsContentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/list/")
public class LoadPage {
    @Autowired
    private NewsContentService newsContentService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private ExpressLogisticsService expressLogisticsService;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "loadpage")
    public ModelAndView loadpage(@RequestParam Integer pageNum,@RequestParam Integer websiteId) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<NewsContent> newsContentList=newsContentService.findAll(pageNum,10,websiteId);
        mav.setViewName("/webapp/load");
        mav.addObject(newsContentList);
        ModelMap model = new ModelMap();
        if(newsContentList != null){
            model.addAttribute("newsList",newsContentList);
        }
        mav.addAllObjects(model);
        return mav;
    }
//    http://www.kuaidi100.com/autonumber/autoComNum?resultv2=1&text=
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "kdsearch_code")
    public String kuaidi(@RequestParam String code) throws Exception {
        String url="http://www.kuaidi100.com/autonumber/autoComNum?resultv2=1&text="+code;
        String json = restTemplate.getForEntity(url, String.class).getBody();
        return json;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "kdsearch")
    public ModelAndView search(@RequestParam String code,@RequestParam String kdcode) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<ExpressLogistics> expressLogisticsList=expressLogisticsService.search(code,kdcode);
        if(expressLogisticsList!=null&&expressLogisticsList.size()>0){
            if(expressLogisticsList.get(0).getSignFlag()){
                mav.addObject("wuliulist",expressLogisticsList);
            }
        }else{
            String url="http://www.kuaidi100.com/query?type="+kdcode+"&postid="+code;
            String json = restTemplate.getForEntity(url, String.class).getBody();
            if(StringUtils.isNotBlank(json)){
                JSONObject jsonObject=JSONObject.parseObject(json);
                int status=jsonObject.getInteger("status");
                String message=jsonObject.getString("message");
                JSONArray datalist=jsonObject.getJSONArray("data");
                if(status==200&&StringUtils.isNotBlank(message)&&"ok".equals(message)
                        &&datalist!=null&&datalist.size()>0){
                    List<ExpressLogistics> list= Lists.newArrayList();
                    boolean sign=false;
                    for(int i=0;i<datalist.size();i++) {
                        JSONObject data = datalist.getJSONObject(i);
                        ExpressLogistics expressLogistics=new ExpressLogistics();
                        expressLogistics.setExpressCode(code);
                        expressLogistics.setExpressType(kdcode);
                        expressLogistics.setNodeTime(data.getDate("ftime"));
                        expressLogistics.setContext(data.getString("context"));
                        expressLogistics.setLocation(data.getString("location"));
                        if (StringUtils.isNotBlank(expressLogistics.getContext()) && expressLogistics.getContext().contains("签收")||sign) {
                            expressLogistics.setSignFlag(true);
                            sign=true;
                        }
                        list.add(expressLogistics);
                    }
                    if(list.size()>0){
                        expressLogisticsService.createExpressLogistics(list);
                        mav.addObject("wuliulist",list);
                    }
                }
            }
        }
        mav.setViewName("/webapp/wuliu");
        return mav;
    }
}

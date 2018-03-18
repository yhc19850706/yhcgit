package com.yhc.lifeall.web.business;

import com.yhc.lifeall.model.netcrawl.NewsContent;
import com.yhc.lifeall.service.NewsContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class WebController {
    @Autowired
    private NewsContentService newsContentService;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "kuaidi")
    public ModelAndView index() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/webapp/seachkd");
        return mav;
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "newslist")
    public ModelAndView newslist(@RequestParam Integer websiteId) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<NewsContent> newsContentList=newsContentService.findAll(1,10,websiteId);
        mav.setViewName("/webapp/newslist");
        mav.addObject(newsContentList);
        ModelMap model = new ModelMap();
        if(newsContentList != null){
            model.addAttribute("newsList",newsContentList);
            model.addAttribute("websiteId",websiteId);
        }
        mav.addAllObjects(model);
        return mav;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "pengpai")
    public ModelAndView pengpai(@RequestParam Integer websiteId) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<NewsContent> newsContentList=newsContentService.findAll(1,10,websiteId);
        mav.setViewName("/webapp/newslist");
        mav.addObject(newsContentList);
        ModelMap model = new ModelMap();
        if(newsContentList != null){
            model.addAttribute("newsList",newsContentList);
        }
        mav.addAllObjects(model);
        return mav;
    }

}

package com.yhc.web.home.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yhc.common.action.BaseAction;
import com.yhc.common.config.BlGlobalVariable;


@RestController
@RequestMapping("/mgz")
public class HomePageAction extends BaseAction{
	/**
	 * 首页访问
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/home_page.wx")
	public ModelAndView main(@RequestParam(required = false) String source,HttpServletResponse response,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		String wxJSConfig  = getJSSDKConfig(request);
		mav.addObject("wxJSConfig", wxJSConfig);
		mav.addObject("shareUrl", BlGlobalVariable.SITE_URL+"/mgz/home_page.wx");
		mav.addObject("siteUrl", BlGlobalVariable.SITE_URL);
		mav.setViewName("webpage/home");
		return mav;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/home_login.wx")
	public ModelAndView login(@RequestParam(required = false) String source,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webpage/login");
		return mav;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/home_event.wx")
	public ModelAndView event(@RequestParam(required = false) String source,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webpage/events");
		return mav;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/home_contact.wx")
	public ModelAndView contact(@RequestParam(required = false) String source,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webpage/contact");
		return mav;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/home_submit.wx")
	public ModelAndView submit(@RequestParam(required = false) String source,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webpage/single");
		return mav;
	}
}

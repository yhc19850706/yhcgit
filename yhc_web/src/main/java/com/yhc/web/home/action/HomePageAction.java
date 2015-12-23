package com.yhc.web.home.action;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yhc.common.action.BaseAction;

@RestController
@RequestMapping("/mgz")
public class HomePageAction extends BaseAction{
	/**
	 * 首页访问
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/home_page.yhc")
	public ModelAndView main(@RequestParam(required = false) String source,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webpage/home");
		return mav;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/home_login.yhc")
	public ModelAndView login(@RequestParam(required = false) String source,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webpage/login");
		return mav;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/home_event.yhc")
	public ModelAndView event(@RequestParam(required = false) String source,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webpage/events");
		return mav;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/home_contact.yhc")
	public ModelAndView contact(@RequestParam(required = false) String source,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webpage/contact");
		return mav;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/home_submit.yhc")
	public ModelAndView submit(@RequestParam(required = false) String source,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webpage/single");
		return mav;
	}
}

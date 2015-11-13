package com.yhc.web.home.action;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yhc.common.action.BaseAction;

@RestController
@RequestMapping("/home")
public class HomePageAction extends BaseAction{
	/**
	 * 首页访问
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/page_index.yhc")
	public ModelAndView main(@RequestParam(required = false) String source,HttpServletResponse response) throws Exception {
		ModelAndView mav = super.getModelAndView();
		return mav;
	}
}

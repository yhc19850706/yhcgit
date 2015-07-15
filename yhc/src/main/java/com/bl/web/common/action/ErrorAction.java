package com.bl.web.common.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorAction extends BaseAction {

	@RequestMapping(value = "/error.bl")
	public ModelAndView error(@RequestParam(required = false) String exception,
		@RequestParam(required = false) String exceptionMessage, @RequestParam(required = false) String statusCode) {
		ModelAndView mav =super.getModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("exceptionMessage", exceptionMessage);
		if ("403".equals(statusCode)) {
			mav.setViewName("error/403");
		} else if ("404".equals(statusCode)) {
			mav.setViewName("error/404");
		} else {
			mav.setViewName("error/500");
		}
		return mav;
	}
	
	@RequestMapping(value = "/connect_error.bl")
	public ModelAndView apiConnectError(@RequestParam(required = false) Map<String,Object> map, @RequestParam(required = false) String respDesc) {
		ModelAndView mav =super.getModelAndView();
		String desc = "";
		try {
			desc = URLDecoder.decode(respDesc,"utf-8");
//			System.out.println("<<<    desc   =>   "+desc+"   >>>");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		mav.addObject("respDesc",desc );
		mav.setViewName("common/pnr_error");
		return mav;
	}
}

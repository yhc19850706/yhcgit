package com.bl.web.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class BlHandlerExceptionResolver implements HandlerExceptionResolver {

	private static Logger log = Logger.getLogger(BlHandlerExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) {
		ModelAndView mav = new ModelAndView();
//		log.debug(ex);
		log.error(ex);
		ex.printStackTrace();

		if (ex instanceof HTTPException) {
			if (403 == ((HTTPException)ex).getStatusCode()) {
				//        		mav.setViewName("error/403");
				mav.setView(new RedirectView("/error.bl?statusCode=403"));
			} else if (404 == ((HTTPException)ex).getStatusCode()) {
				//        		mav.setViewName("error/404");
				mav.setView(new RedirectView("/error.bl?statusCode=404"));
			} else {
				//        		mav.setViewName("error/404");
				mav.setView(new RedirectView("/error.bl?statusCode=404"));
			}
		} else {
			//        	mav.setViewName("error/500");
			mav.setView(new RedirectView("/error.bl"));
		}

		return mav;
	}

}

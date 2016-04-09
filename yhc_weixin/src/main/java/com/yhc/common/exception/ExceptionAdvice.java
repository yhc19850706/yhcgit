/**   
 * ExceptionAdvice.java 
 * com.common.exception 
 * @Description:
 * @author Yhc yinhc@yinhu.com
 * 2015年10月27日 下午4:08:17 
 * @version V1.0   
 */

package com.yhc.common.exception;

import java.util.Map;
import java.util.TreeMap;

import javax.validation.ValidationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yhc.common.model.Response;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {
	protected Log	logger	= LogFactory.getLog(ExceptionAdvice.class);

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Response handleHttpMessageNotReadableException(
			HttpMessageNotReadableException e) {
		logger.error("参数解析失败", e);
		return new Response().failure("could_not_read_json");
	}

	/**
	 * 405 - Method Not Allowed
	 */
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Response handleHttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException e) {
		logger.error("不支持当前请求方法", e);
		return new Response().failure("request_method_not_supported");
	}

	/**
	 * 415 - Unsupported Media Type
	 */
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public Response handleHttpMediaTypeNotSupportedException(Exception e) {
		logger.error("不支持当前媒体类型", e);
		return new Response().failure("content_type_not_supported");
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public Response handleException(Exception e) {
		logger.error("服务运行异常", e);
		return new Response().failure(e.getMessage());
	}
	
	 /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Response handleValidationException(ValidationException e) {
        logger.error("参数验证失败", e);
        return new Response().failure("validation_exception");
    }
    /*
    * 异常页面控制 
    *  
    * @param runtimeException 
    * @return 
    */  
   @ExceptionHandler(RuntimeException.class)  
   public Response runtimeExceptionHandler(RuntimeException runtimeException,  
           ModelMap modelMap) {  
       logger.error(runtimeException.getLocalizedMessage());  
       return new Response().failure("runtime_exception"); 
   }
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WeixinException.class)
    public Response handleTokenException(WeixinException e) {
        logger.error("微信异常", e);
        return new Response().failure("token_exception");
    }
}

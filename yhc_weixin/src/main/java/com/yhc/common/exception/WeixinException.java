package com.yhc.common.exception;

public class WeixinException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8972687444774898897L;

	/**
	 *
	 */
	public WeixinException() {
	}

	/**
	 * @param message
	 */
	public WeixinException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public WeixinException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public WeixinException(String message, Throwable cause) {
		super(message, cause);
	}

}

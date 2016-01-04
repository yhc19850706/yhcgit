package com.yhc.web.security;

import java.io.Serializable;

import org.apache.shiro.util.SimpleByteSource;

public class MySimpleByteSource extends SimpleByteSource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MySimpleByteSource(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}
}

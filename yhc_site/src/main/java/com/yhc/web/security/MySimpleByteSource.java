package com.yhc.web.security;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

public class MySimpleByteSource extends SimpleByteSource implements Externalizable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MySimpleByteSource(ByteSource str) {
		super(str);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
	 
}

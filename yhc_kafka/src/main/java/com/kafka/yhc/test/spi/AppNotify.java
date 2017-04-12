package com.kafka.yhc.test.spi;

@SPI
public interface AppNotify {
	
	public void notify(String message) throws Exception;

}

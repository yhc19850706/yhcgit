package com.kafka.yhc.test.spi;

/**
 * Helper Class for hold a value.
 * 
 * @author sunsx
 */
public class Holder<T> {

	private volatile T value;

	public void set(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}
}

package com.test;

import javax.xml.crypto.Data;

import redis.clients.jedis.Jedis;

public class TestMain {
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("127.0.0.1",6379);
		String keys = "name";

		// 删数据
		jedis.del(keys);
		// 存数据
		jedis.set(keys, "snowolf");
		// 取数据
		String value = jedis.get(keys);

		System.out.println(value);
	}

}

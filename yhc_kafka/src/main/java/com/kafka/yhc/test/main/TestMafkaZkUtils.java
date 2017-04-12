package com.kafka.yhc.test.main;

import java.util.Date;

import com.kafka.yhc.test.consumer.KafkaConsumer;
import com.kafka.yhc.test.producer.KafkaProducer;

public class TestMafkaZkUtils {
	//简单的发送接收消息
		public static void main(String[] args)  
	    {  
	        
	  
//	        KafkaConsumer consumerThread = new KafkaConsumer("investTopic");  
//	        consumerThread.start();
			System.out.println(System.currentTimeMillis()+"-------------");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(System.currentTimeMillis());
	        
	    }
}

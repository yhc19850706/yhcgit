package com.kafka.yhc.test.main;

import com.kafka.yhc.test.producer.KafkaProducer;

public class ProduceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KafkaProducer producerThread = new KafkaProducer("investTopic");  
        producerThread.start();
        KafkaProducer producerThread2 = new KafkaProducer("investTopic");  
        producerThread2.start();
	}

}

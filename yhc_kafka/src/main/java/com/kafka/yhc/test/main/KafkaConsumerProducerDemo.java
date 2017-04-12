package com.kafka.yhc.test.main;

import com.kafka.yhc.test.consumer.KafkaConsumer;
import com.kafka.yhc.test.producer.KafkaProducer;
import com.kafka.yhc.test.producer.KafkaProperties;

public class KafkaConsumerProducerDemo {
	//简单的发送接收消息
	public static void main(String[] args)  
    {  
        
  
        KafkaConsumer consumerThread = new KafkaConsumer("investTopic");  
        consumerThread.start();
        
    }
}

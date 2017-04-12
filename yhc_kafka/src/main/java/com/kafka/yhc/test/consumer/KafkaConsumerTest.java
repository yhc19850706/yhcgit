package com.kafka.yhc.test.consumer;

import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.kafka.yhc.test.main.KafkaUtil;
/**
 * kafka client 0.10.0.0
 * @author admin
 *
 */
public class KafkaConsumerTest {
	public static void main(String[] args) throws Exception{
		KafkaConsumer<String, String> consumer = KafkaUtil.getConsumer();
		consumer.subscribe(Arrays.asList("test"));
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(1000);
			for(ConsumerRecord<String, String> record : records) {
				System.out.println("fetched from partition " + record.partition() + ", offset: " + record.offset() + ", message: " + record.value());
			}
		}
	}
}

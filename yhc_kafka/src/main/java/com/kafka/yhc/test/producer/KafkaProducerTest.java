package com.kafka.yhc.test.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.kafka.yhc.test.main.KafkaUtil;
/**
 * kafka client 0.10.0.0
 * @author admin
 *
 */
public class KafkaProducerTest {
	public static void main(String[] args) throws Exception{
		Producer<String, String> producer = KafkaUtil.getProducer();
		int i = 0;
		while(true) {
			ProducerRecord<String, String> record = new ProducerRecord<String, String>("investTopic", String.valueOf(i), "this is message"+i);
			producer.send(record, new Callback() {
				public void onCompletion(RecordMetadata metadata, Exception e) {
					if (e != null)
						e.printStackTrace();
					System.out.println("message send to partition " + metadata.partition() + ", offset: " + metadata.offset());
				}
			});
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}

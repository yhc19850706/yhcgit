package com.kafka.yhc.test.producer;

import java.util.Properties;

import kafka.producer.KeyedMessage;  
import kafka.producer.ProducerConfig;


/**
 * kafka client 0.8.2.2
 * @author admin
 *
 */
public class KafkaProducer extends Thread
{
    private final kafka.javaapi.producer.Producer<Integer, String> producer;
    private final String topic;
    private final Properties props = new Properties();

    public KafkaProducer(String topic)
    {
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "localhost:9092");
        props.put("zk.connect", "localhost:2181");
        producer = new kafka.javaapi.producer.Producer<Integer, String>(new ProducerConfig(props));
        this.topic = topic;
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true)
        {
            String messageStr = new String("Message_" + messageNo);
            System.out.println("Send:" + messageStr+Thread.currentThread().getName());
            producer.send(new KeyedMessage<Integer, String>(topic, messageStr+Thread.currentThread().getName()));
            messageNo++;
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

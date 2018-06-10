package com.terry.gakkisimle.IM.sys;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProductor {

    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", "127.0.0.1:9092");

        properties.put("metadata.broker.list", "localhost:9092");

        /**
         * "key.serializer" 的类型根据ProducerRecord<Integer,String>中的类型来确定，
         * Integer对应的为IntegerSerializer,String对应的为StringSerializer
         * key.serializer和value.serializer根据定义的ProducerRecord类型来对应
         */
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        /**
         * KeyedMessage中"test-topic"为topic的名字，"test-message"为消息内容
         * 6为对应的key值
         * "hello"为对应的value值
         */
        ProducerRecord<Integer,String> producerRecord = new ProducerRecord<>("test-topic", 6,"hello");

        kafkaProducer.send(producerRecord);


        Thread.sleep(1000);

        kafkaProducer.close();

        System.out.println("product end");
    }
}
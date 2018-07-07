package com.terry.gakkisimle.IM.sys;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProductor {

    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", "localhost:9092");

        properties.put("metadata.broker.list", "localhost:9092");

        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer kafkaProducer = new KafkaProducer(properties);

        ProducerRecord<String,String> producerRecord = new ProducerRecord<>("test", "one","diu ni lao mu");

        kafkaProducer.send(producerRecord);


        Thread.sleep(1000);

        kafkaProducer.close();

        System.out.println("product end");
    }
}
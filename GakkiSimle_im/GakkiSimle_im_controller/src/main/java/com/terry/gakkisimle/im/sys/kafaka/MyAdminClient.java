package com.terry.gakkisimle.im.sys.kafaka;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;


/**
 * @Description:kafka的管理
 * @Author:TERRY_MENG
 * @Date:2018-06-19
 */
public class MyAdminClient {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.103:9092");

        try (AdminClient client = AdminClient.create(props)) {
//            createTopics(client);
//            describeCluster(client);
           //listAllTopics(client);
          // describeTopics(client);
//            alterConfigs(client);
//            describeConfig(client);
           deleteTopics(client);
        }
    }
    public static void deleteTopics(AdminClient client) throws ExecutionException, InterruptedException {
        KafkaFuture<Void> futures = client.deleteTopics(Arrays.asList("hsy")).all();
        futures.get();
        System.out.println("删除成功");
    }

    public static void describeTopics(AdminClient client) throws ExecutionException, InterruptedException {
        DescribeTopicsResult ret = client.describeTopics(Arrays.asList("hsy"));
        Map<String, TopicDescription> topics = ret.all().get();
        for (Map.Entry<String, TopicDescription> entry : topics.entrySet()) {
            System.out.println(entry.getKey() + " ===> " + entry.getValue());
        }
    }

    public static void listAllTopics(AdminClient client) {
        ListTopicsResult  list= client.listTopics();
    }
}

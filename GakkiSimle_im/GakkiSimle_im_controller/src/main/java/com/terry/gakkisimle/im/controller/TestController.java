package com.terry.gakkisimle.im.controller;

import com.mongodb.BasicDBObject;
import com.terry.gakkisimle.core.common.model.RestResult;
import com.terry.gakkisimle.core.common.web.controller.BaseController;
import com.terry.gakkisimle.im.service.CardService;
import com.terry.gakkisimle.im.service.MenuService;
import com.terry.gakkisimle.wechat.entity.po.spider.Card;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
public class TestController extends BaseController {


    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CardService cardService;
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Autowired
    private MenuService menuService;

    @RequestMapping("/helloworld")
    public String test(){
        return "IM调用";
    }

    @GetMapping("/putKafkaTopic")
    public String putKafkaTopic(String topic,Integer part,String key,String content){
        kafkaTemplate.send(topic,part,key,content);
        return "done";
    }
    @GetMapping("/getMenus")
    public RestResult<List<Object>> getMenus(){
        List<Object> res=menuService.getMenus();
        return new RestResult<>(200, "success", res);
    }


    //@KafkaListener(id = "terrymeng",groupId = "home",topicPartitions = @TopicPartition(topic = "hsy",partitions = "0"))
    public void processMessage2(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        logger.info("topic{},part{},key{},message{}",record.topic(),record.partition(),record.key());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("message is {} ", message);
        }
    }

   // @KafkaListener(id = "terry",groupId = "home",topicPartitions = @TopicPartition(topic = "hsy",partitions = "1"))
    public void processMessage(ConsumerRecord<?, ?> record) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            logger.info("topic{},part{},key{},message{}",record.topic(),record.partition(),record.key());
            if (kafkaMessage.isPresent()) {
                Object message = kafkaMessage.get();
                logger.info("message is {} ", message);
            }
    }

    @RequestMapping("/getAllCard")
    public List<Card> getAllCard(){
        return cardService.getALL();
    }

    @GetMapping("/getAllCardMogo")
    public Object getAllCardMogo(){
        return cardService.getAllByMongo();
    }

    @GetMapping("/getAllCardReact")
    public Object getAllCardReact(){
        return cardService.getAllCardReact();
    }

    @GetMapping("/getOneMogo")
    public Object getOne(String id){
        BasicDBObject basicDBObject=cardService.findById(id);
        return basicDBObject;
    }

    @PostMapping("/deleteOneMogo")
    public void deleteOne(String id){
        cardService.deleteById(id);
    }

    @PostMapping("/insertOrSaveMogo")
    public void insertOrSave(String object){
        cardService.insertOrupdate(BasicDBObject.parse(object));
    }

    @GetMapping(value = "/testFulx")
    public Flux testFulx(){
        return Flux.fromStream(cardService.getAllByMongo().getMappedResults().stream());
    }

    @GetMapping(value = "/testMono")
    public Flux<String> testMono() {
        return Flux.just("压力测试" + System.currentTimeMillis());

    }

    @RequestMapping("/putRedis/{name}/{score}")
    public String test2(@PathVariable String name,@PathVariable Integer score){
        ZSetOperations<String,Object> set= redisTemplate.opsForZSet();
        set.add("rank",name,score);
        return "成功";
    }
    @RequestMapping("/getRedisRank/{name}")
    public Long test3(@PathVariable String name){
        Long res=  redisTemplate.opsForZSet().rank("rank",name);
        return res;
    }
    @RequestMapping("/getRedis/{name}")
    public Set test4(@PathVariable String name){
        Set res=  redisTemplate.opsForZSet().range("rank",0,1);
        return res;
    }

    @RequestMapping("/putCache")
    public String test4(String name,String value){
        CacheManager cacheManager=CacheManager.newInstance();
        Cache cache=cacheManager.getCache("test1");
        Element element=new Element(name,value);
        cache.put(element);
        cache.flush();
        cacheManager.shutdown();
        return "success";
    }

    @RequestMapping("/getCache")
    public String test5(String name){
        CacheManager cacheManager=CacheManager.getInstance();
        Cache cache=cacheManager.getCache("test1");
        this.logger.info(String.valueOf(cache.isElementInMemory(name)));
        this.logger.info(String.valueOf(cache.isElementOnDisk(name)));
        Element element=cache.get(name);
        return (String) element.getObjectValue();
    }
}

package com.terry.gakkisimle.IM.controller;

import com.mongodb.BasicDBObject;
import com.terry.gakkisimle.IM.service.CardService;
import com.terry.gakkisimle.core.common.web.controller.BaseController;
import com.terry.gakkisimle.wechat.entity.po.spider.Card;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@RestController
public class TestController extends BaseController {


    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CardService cardService;

    @RequestMapping("/helloworld")
    public String test(){
        return "IM调用";
    }

    @GetMapping("/getAllCard")
    public Object getAllCard(){
        return cardService.getAllByMongo();
    }
    @GetMapping("/getOne")
    public Object getOne(String id){
        BasicDBObject basicDBObject=cardService.findById(id);
        return basicDBObject;
    }

    @PostMapping("/deleteOne")
    public void deleteOne(String id){
         cardService.deleteById(id);
    }

    @PostMapping("/insertOrSave")
    public void insertOrSave(String object){
        cardService.insertOrupdate(BasicDBObject.parse(object));
    }

    @GetMapping(value = "/testFulx",produces =MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Card> testFulx(){

        return Flux.fromStream(cardService.getAllByMongo()
                .getMappedResults().stream()).delayElements(Duration.ofSeconds(1));
    }

    @GetMapping(value = "/testMono",produces  = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Object> testFulx2(){

       return Flux.interval(Duration.ofSeconds(1)).
                map(l -> new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }


    @RequestMapping("/putRedis/{name}/{score}")
    public String test2(@PathVariable String name,@PathVariable Integer score){
        ZSetOperations<String,String> set= redisTemplate.opsForZSet();
        set.add("rank",name,score);
        return "成功";
    }
    @RequestMapping("/getRedis")
    public Long test3(){
        Long res=  redisTemplate.opsForZSet().rank("rank","terry");
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

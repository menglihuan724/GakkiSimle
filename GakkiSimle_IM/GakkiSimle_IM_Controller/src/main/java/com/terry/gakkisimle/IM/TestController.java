package com.terry.gakkisimle.IM;

import com.terry.gakkisimle.IM.service.CardService;
import com.terry.gakkisimle.core.common.web.controller.BaseController;
import com.terry.gakkisimle.wechat.entity.po.spider.Card;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Card> getAllCard(){
        return cardService.getAllByMongo();
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

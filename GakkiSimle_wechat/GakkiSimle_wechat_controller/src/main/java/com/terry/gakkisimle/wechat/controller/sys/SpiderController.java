package com.terry.gakkisimle.wechat.controller.sys;

import com.terry.gakkisimle.wechat.spider.WeiBoSpider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Spider")
public class SpiderController {
    @RequestMapping("/startSpider")
    public String startSpider(){
        List<String> list=new ArrayList<>(20);
        for(int page=1;page<=1;page++){
            String url="https://m.weibo.cn/api/container/getIndex?containerid=1076031882811994&page="+page;
            list.add(url);
            Spider.create(new WeiBoSpider()).addUrl(url).start();
        }
        return "success";
    }


}
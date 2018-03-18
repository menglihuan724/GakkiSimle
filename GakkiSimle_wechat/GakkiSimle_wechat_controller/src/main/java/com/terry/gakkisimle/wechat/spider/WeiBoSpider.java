package com.terry.gakkisimle.wechat.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.terry.gakkisimle.wechat.entity.vo.po.spider.Card;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

public class WeiBoSpider implements PageProcessor {
    private Site site = Site.me()//.setHttpProxy(new HttpHost("127.0.0.1",8888))
            .setRetryTimes(3).setSleepTime(1000).setUseGzip(true).setCharset("utf-8");

    @Override
    public void process(Page page) {
        List<String> url_list = new ArrayList();
        JSONObject jsonObject = (JSONObject) JSONObject.parse(page.getRawText());
        JSONObject data = (JSONObject) jsonObject.get("data");
        JSONArray cards = (JSONArray) data.get("cards");

        for (int i = 0; i < cards.size(); i++) {
            //内容信息
            JSONObject mblog = (JSONObject) cards.getJSONObject(i).get("mblog");
            Card card=new Card();
            if(mblog.containsKey("id")) {
                String id = mblog.getString("id");
                card.setId(id);
            }else {
                continue;
            }
            if(mblog.containsKey("text")){
                String text=  mblog.getString("text");
                card.setText(text);
            }
            if(mblog.containsKey("created_at")){
                String created_at=  mblog.getString("created_at");
                card.setCreated_at(created_at);
            }
            if(mblog.containsKey("isLongText")){
                boolean isLongText=  mblog.getBoolean("isLongText");
                card.setLongText(isLongText);
            }
            if(mblog.containsKey("textLength")){
                Integer textLength=  mblog.getInteger("textLength");
                card.setTextLength(textLength);
            }
            if(mblog.containsKey("pics")){
                JSONArray pics=mblog.getJSONArray("pics");
                card.setPicList(pics.toJSONString());
            }
            if(mblog.containsKey("page_info")){
                JSONObject picinfo=mblog.getJSONObject("page_info");
                card.setPicInfo(picinfo.toJSONString());
            }
            System.out.println(card);
            card.insertOrUpdate();
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>(20);
        String[] urls = new String[20];
        for(int page=1;page<=1;page++){
            String url="https://m.weibo.cn/api/container/getIndex?containerid=1076031882811994&page="+page;
            list.add(url);
            Spider.create(new WeiBoSpider()).addUrl(url).start();
        }

    }
}

package com.terry.gakkisimle.IM.service;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.terry.gakkisimle.wechat.entity.po.spider.Card;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.List;

public interface CardService {
    List<Card> getALL() ;
    AggregationResults<Card> getAllByMongo();
    BasicDBObject findById(String name);
    void deleteById(String id);
    void insertOrupdate(BasicDBObject basicDBObject);
}
package com.terry.gakkisimle.IM.service.imp;

import com.terry.gakkisimle.IM.mapper.CardMapper;
import com.terry.gakkisimle.IM.service.CardService;
import com.terry.gakkisimle.wechat.entity.po.spider.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Card> getALL(){
        return cardMapper.getAll("test.card");
    }

    @Override
    public List<Card> getAllByMongo() {
        List<Card> cards =  mongoTemplate.findAll(Card.class);
        return cards;
    }

}
package com.terry.gakkisimle.im.service.imp;

import com.mongodb.BasicDBObject;
import com.terry.gakkisimle.im.dao.CardDao;
import com.terry.gakkisimle.im.mapper.CardMapper;
import com.terry.gakkisimle.im.service.CardService;
import com.terry.gakkisimle.wechat.entity.po.spider.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private CardDao cardDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Card> getALL(){
        return cardMapper.getAll("card");
    }

    @Override
    public AggregationResults<Card> getAllByMongo() {
        Aggregation agg = Aggregation.newAggregation(
//                group("picInfo.type").count().as("total"),
                limit(5));
        AggregationResults<Card> cards =  mongoTemplate.aggregate( agg,"card",Card.class);
        return cards;
    }

    @Override
    public BasicDBObject findById(String id) {
        return (BasicDBObject) mongoTemplate.getCollection("card")
                .find(new BasicDBObject("_id",id));
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.getCollection("card").deleteOne(new BasicDBObject("id",id));
    }

    @Override
    public void insertOrupdate(BasicDBObject basicDBObject) {
        Query query=new Query();
        query.addCriteria( Criteria.where("_id").is(basicDBObject.getString("id")));
        Update update=new Update();
        update.set("text",basicDBObject.getString("text"));
        mongoTemplate.updateFirst(query,update,"card");
    }

    @Override
    public List<Card> getAllCardReact() {
        return (List<Card>) cardDao.findAll();
    }


}
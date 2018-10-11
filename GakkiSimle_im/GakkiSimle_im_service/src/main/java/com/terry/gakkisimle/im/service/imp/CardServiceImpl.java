package com.terry.gakkisimle.im.service.imp;

import brave.Span;
import brave.Tracer;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;

@Service("cardService1")
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private CardDao cardDao;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private Tracer tracer;
    @Resource(name = "cardService2")
    CardService cardService;

    @Override
    public List<Card> getALL(){
        return cardMapper.getAll("card");
    }

    @Override
    public AggregationResults<Card> getAllByMongo() {
        Span span = tracer.currentSpan();
        span.tag("name","menglihuan");
        Aggregation agg = Aggregation.newAggregation(
//                group("picInfo.type").count().as("total"),
                limit(5));
        AggregationResults<Card> cards =  mongoTemplate.aggregate( agg,"card",Card.class);
        tracer.nextSpan().tag("girlfriend","hsy").finish();
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

    /**
    *@Author:terrmeng
    *@Date:2018/10/9
    *@Description: spring事务传播 参考:https://blog.csdn.net/pml18710973036/article/details/58607148
    */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void A() throws Exception {
        System.out.println("执行方法A");
        Card card=new Card();
        card.setId("A");
        cardDao.save(card);
        cardService.B();
        throw new Exception("A报错");
    }

    @Override
    public void B() throws Exception {

    }
}
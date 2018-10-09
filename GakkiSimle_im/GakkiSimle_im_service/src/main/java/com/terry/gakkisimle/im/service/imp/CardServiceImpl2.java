package com.terry.gakkisimle.im.service.imp;

import com.mongodb.BasicDBObject;
import com.terry.gakkisimle.im.dao.CardDao;
import com.terry.gakkisimle.im.service.CardService;
import com.terry.gakkisimle.wechat.entity.po.spider.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author:TERRY_MENG
 * @Date:2018-10-09
 */
@Service("cardService2")
public class CardServiceImpl2 implements CardService {
    @Autowired
    private CardDao cardDao;
    @Override
    public List<Card> getALL() {
        return null;
    }

    @Override
    public AggregationResults<Card> getAllByMongo() {
        return null;
    }

    @Override
    public BasicDBObject findById(String name) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void insertOrupdate(BasicDBObject basicDBObject) {

    }

    @Override
    public List<Card> getAllCardReact() {
        return null;
    }

    @Override
    public void A() throws Exception {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void B() throws Exception {

        System.out.println("执行方法B REQUIRES_NEW");
        Card card=new Card();
        card.setId("B");
        cardDao.save(card);
        //throw new Exception("B报错");
    }
}

//package com.terry.gakkisimle.wechat.service.imp;
//
//import com.terry.gakkisimle.wechat.entity.vo.po.spider.Card;
//import com.terry.gakkisimle.wechat.entity.vo.po.spider.ProxCard;
//import com.terry.gakkisimle.wechat.mapper.CardMapper;
//import com.terry.gakkisimle.wechat.service.MainPageService;
//import com.terry.gakkisimle.wechat.service.TestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.lang.reflect.Proxy;
//import java.util.List;
//@Service
//public class MainPageServiceImp implements MainPageService {
//    @Autowired
//    CardMapper cardMapper;
//    @Autowired
//    TestService testService;
//    @Override
//    public List<Card> getAllCard() {
//        Card var1=new Card();
//        List<Card> list=var1.selectAll();
//        return list;
//    }
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void insertCard(){
//        Card var1=  new Card();
//        ClassLoader loader = Card.class.getClassLoader();
//        Class<?>[] interfaces = var1.getClass().getInterfaces();
//        ProxCard var2=new ProxCard(var1);
//        Card proxy = (Card) Proxy.newProxyInstance(loader, interfaces, var2);
//        proxy.setId("123");
//        cardMapper.insert(var1);
//        testService.test();
//    }
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void insertCard2(){
//        Card var1=new Card();
//        var1.setId("333");
//        cardMapper.insert(var1);
//    }
//}
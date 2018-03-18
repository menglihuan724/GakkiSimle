package com.terry.gakkisimle.wechat.service.imp;

import com.terry.gakkisimle.wechat.entity.vo.po.spider.Card;
import com.terry.gakkisimle.wechat.service.MainPageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MainPageServiceImp implements MainPageService {
    @Override
    public List<Card> getAllCard() {
        Card var1=new Card();
        List<Card> list=var1.selectAll();
        return list;
    }
}
package com.terry.gakkisimle.IM.service.imp;

import com.terry.gakkisimle.IM.mapper.CardMapper;
import com.terry.gakkisimle.IM.service.CardService;
import com.terry.gakkisimle.wechat.entity.po.spider.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;
    @Override
    public List<Card> getALL(){
        return cardMapper.getAll("test.card");
    }
}
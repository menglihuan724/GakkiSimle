package com.terry.gakkisimle.wechat.service;

import com.terry.gakkisimle.wechat.entity.vo.po.spider.Card;

import java.util.List;

public interface MainPageService {
    List<Card> getAllCard();
    void insertCard();
    void insertCard2();
}
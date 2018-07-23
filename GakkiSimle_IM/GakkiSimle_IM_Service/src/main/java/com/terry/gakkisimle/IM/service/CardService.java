package com.terry.gakkisimle.IM.service;

import com.terry.gakkisimle.wechat.entity.po.spider.Card;
import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

public interface CardService {
    List<Card> getALL() ;
    List<Card> getAllByMongo();
}
package com.terry.gakkisimle.im.dao;

import com.terry.gakkisimle.wechat.entity.po.spider.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardDao extends CrudRepository<Card, String> {
}
package com.terry.gakkisimle.im.mapper;

import com.terry.gakkisimle.wechat.entity.po.spider.Card;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface CardMapper extends Mapper<Card> {
    @Select("select * from ${table}")
    List<Card> getAll(@Param("table") String name);
}
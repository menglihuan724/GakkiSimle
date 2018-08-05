package com.terry.gakkisimle.im.dao;

import com.terry.gakkisimle.im.entity.po.Tree;
import org.springframework.data.repository.CrudRepository;

public interface MenuDao extends CrudRepository<Tree, String> {
}
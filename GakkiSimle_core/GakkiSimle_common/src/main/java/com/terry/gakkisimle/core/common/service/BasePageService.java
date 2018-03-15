package com.terry.gakkisimle.core.common.service;


import com.terry.gakkisimle.core.common.model.PageInfo;

/**
 * Created by terrymeng
 *
 */
public interface BasePageService<T> extends BaseService<T> {

    PageInfo<T> listPage(PageInfo<T> pageInfo, T entity);
}

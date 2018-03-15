package com.terry.gakkisimle.core.common.web.controller;

import com.alibaba.fastjson.JSON;
import com.terry.gakkisimle.core.common.model.PageInfo;
import com.terry.gakkisimle.core.common.model.PageRestResultBuilder;
import com.terry.gakkisimle.core.common.model.RestResult;
import com.terry.gakkisimle.core.common.web.dto.PageInfoDto;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by terrymeng on 2017/02/25.
 */
public abstract class BasePageController<T> extends BaseController {

    @RequestMapping("/list")
    public RestResult listPage(PageInfoDto pageInfoDto) {
        logger.debug("listPage pageInfoDto: {}", pageInfoDto);
        PageInfo<T> pageInfo = this.listPageInfo(PageInfo.<T>build(pageInfoDto));
        logger.debug("listPage {}", JSON.toJSONString(pageInfo));
        return PageRestResultBuilder.builder().success(pageInfo).build();
    }

    public abstract PageInfo<T> listPageInfo(PageInfo<T> pageInfo);
}

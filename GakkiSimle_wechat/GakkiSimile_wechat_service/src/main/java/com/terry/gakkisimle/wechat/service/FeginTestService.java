package com.terry.gakkisimle.wechat.service;

import com.terry.gakkisimle.wechat.entity.vo.Test;
import com.terry.gakkisimle.wechat.service.imp.FeginTestServiceImp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "gakkisimle-wechat",fallback = FeginTestServiceImp.class)
public interface FeginTestService {


    @RequestMapping( value = "/gakkisimle/helloworld")
    String test();
}
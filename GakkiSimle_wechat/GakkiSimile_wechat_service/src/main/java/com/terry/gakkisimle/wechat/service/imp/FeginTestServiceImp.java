package com.terry.gakkisimle.wechat.service.imp;

import com.terry.gakkisimle.wechat.service.FeginTestService;
import org.springframework.stereotype.Service;

@Service
public class FeginTestServiceImp implements FeginTestService {
    @Override
    public String test() {
        return "request error";
    }
}
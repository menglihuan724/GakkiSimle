package com.terry.sys;

import com.terry.common.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController extends BaseController {
    @Value("${server.port}")
    String test;
    @RequestMapping("/helloworld")
    public String test(){
        return test;
    }
}

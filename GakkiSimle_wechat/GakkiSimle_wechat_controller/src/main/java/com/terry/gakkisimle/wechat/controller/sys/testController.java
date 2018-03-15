package com.terry.gakkisimle.wechat.controller.sys;

import com.terry.gakkisimle.core.common.web.controller.BaseController;
import com.terry.gakkisimle.wechat.entity.vo.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testController extends BaseController {
    //@Value("${server.port}")
    String test="123";
    @RequestMapping("/helloworld")
    public List<Test> test(){
        Test a=new Test();
        List<Test> res=a.selectAll();
        return res;
    }
}

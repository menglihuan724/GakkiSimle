package com.terry.gakkisimle.wechat.controller.sys;

import com.terry.gakkisimle.core.common.web.controller.BaseController;
import com.terry.gakkisimle.wechat.entity.vo.Test;
import com.terry.gakkisimle.wechat.service.FeginTestService;
import com.terry.gakkisimle.wechat.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController extends BaseController {
    @Autowired
    FeginTestService feginTestService;
    @Autowired
    MainPageService mainPageService;
    @RequestMapping("/helloworld")
    public String test(){
        Test a=new Test();
        List<Test> res=a.selectAll();
        return "wechat调用";
    }
    @RequestMapping("/fegin")
    public  String fegin(){
        return feginTestService.test();
    }
    @RequestMapping("/transcation")
    public  void transcation(){
         mainPageService.insertCard();
    }

}

package com.terry.gakkisimle.wechat.controller.sys;

import com.terry.gakkisimle.core.common.model.RestResult;
import com.terry.gakkisimle.wechat.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/main")
public class MainPageController {

    @Autowired
    MainPageService mainPageService;
    @RequestMapping("/queryAll")
    public RestResult queryList(){
        RestResult res=new RestResult();
        res.setData(mainPageService.getAllCard());
        return res;
    }
}
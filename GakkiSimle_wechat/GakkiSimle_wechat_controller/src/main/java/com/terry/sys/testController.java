package com.terry.sys;

import com.terry.common.web.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController extends BaseController {
    @RequestMapping("/helloworld")
    public String test(){
        return "helloworld";
    }
}

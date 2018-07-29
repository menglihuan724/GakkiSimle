package com.terry.gakkisimle.im.controller;

import com.terry.gakkisimle.im.service.ExcelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/excel")
@Api(description = "导入数据")
public class ExcelController {
    @Autowired
    ExcelService excelService;
    @PostMapping("/insertNum")
    public String insertNum(HttpServletRequest res){
        try {
            excelService.ImportNum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
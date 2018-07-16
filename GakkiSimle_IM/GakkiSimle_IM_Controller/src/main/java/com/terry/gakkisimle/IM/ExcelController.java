package com.terry.gakkisimle.IM;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/excel")
@Api(description = "导入数据")
public class ExcelController {
    @Autowired
    ExcelService excelService;
    @PostMapping("/insertNum")
    public String insertNum(HttpServletRequest res){
        excelService.ImportNum();
        return "ok";
    }
}
package com.marklogzhu.platform.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
@Api(tags = "测试接口")
public class TestController {

    @ApiOperation(value = "打印输出数据",nickname = "打印输出数据",httpMethod ="GET")
    @RequestMapping(value = "/print",method = RequestMethod.GET)
    @ResponseBody
    public String print(){
        return "Hello world!";
    }



}

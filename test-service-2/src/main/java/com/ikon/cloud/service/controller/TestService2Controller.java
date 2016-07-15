package com.ikon.cloud.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService2Controller {

    @RequestMapping(value = "/status")
    public String getStatus(){
        return "这是服务2";
    }

//    @RequestMapping(value = "/status2")
//    public String getStatus2(){
//        return "这是服务2";
//    }
}

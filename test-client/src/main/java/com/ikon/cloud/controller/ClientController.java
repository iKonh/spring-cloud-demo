package com.ikon.cloud.controller;

import com.ikon.cloud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    /**
     * 负载均衡测试api
     * @return 各服务返回结果
     */
    @RequestMapping(value = "loadBalance", method = RequestMethod.GET)
    public List<String> loadBalanceTest() {
        return clientService.testLoadBalance();
    }

    /**
     * 隔断机制测试api
     * @return 隔断结果
     */
    @RequestMapping(value = "circuitBreaker", method = RequestMethod.GET)
    public List<String> circuitBreakerTest() {
        return clientService.testCircuitBreaker();
    }
}

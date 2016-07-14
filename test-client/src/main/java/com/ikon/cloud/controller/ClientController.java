package com.ikon.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class ClientController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${service.url}")
    String serviceUrl;

    @RequestMapping(value = "loadBalance", method = RequestMethod.GET)
    public List<String> loadBalanceTest() {
        String result = sendRequest();
        List<String> request = new ArrayList<>();
        for (int i = 0;i < 50;i++) {
            request.add(String.valueOf(i));
        }
        List<String> response = request.parallelStream().map(t -> sendRequest()).collect(Collectors.toList());
        return response;
    }

    private String sendRequest() {
        String result = restTemplate.getForObject(serviceUrl, String.class);
        return result;
    }
}

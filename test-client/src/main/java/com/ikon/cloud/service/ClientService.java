package com.ikon.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @Value("${service.url}")
    String serviceUrl;

    public List<String> testLoadBalance() {
        List<String> request = new ArrayList<>();
        String url = serviceUrl + "/status";
        for (int i = 0;i < 50;i++) {
            request.add(url);
        }
        List<String> response = request.parallelStream().map(this::sendRequest).collect(Collectors.toList());
        return response;
    }

    private String sendRequest(String url) {
        return restTemplate.getForObject(url, String.class);
    }

    private List<String> fallback() {
        List<String> response = new ArrayList<>();
        response.add("服务隔断");
        return response;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public List<String> testCircuitBreaker() {
        List<String> request = new ArrayList<>();
        // test-service-1的status2接口可以正常访问
        // test-service-2没有status2接口，因此当连接切为status2的时候会报404错误，触发断路器
        String url = serviceUrl + "/status2";
        for (int i = 0;i < 50;i++) {
            request.add(url);
        }
        List<String> response = request.parallelStream().map(this::sendRequest).collect(Collectors.toList());
        return response;
    }
}

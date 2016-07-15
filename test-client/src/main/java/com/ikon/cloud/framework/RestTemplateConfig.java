package com.ikon.cloud.framework;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置RestTemplate
 * 新版spring cloud不会自动添加RestTemplate，而是修改spring容器中的现有RestTemplate
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}

# spring-cloud-demo

## Eureka-Server Eureka服务器启动项
#### Eureka:spring-cloud中起服务发现作用，其他服务需在该服务中注册

## test-service-1，test-service-2 注册于Eureka上的服务

## test-client 用于访问注册在Eureka上的服务
#### Ribbon:结合eureka，对其注册的同一个application.name下的所有实例(即服务)做负载均衡  在spring-cloud-eureka中封装于RestTemplate中
#### Hystrix:隔断机制，当产生错误时启用备用方案
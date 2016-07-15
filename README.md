# spring-cloud-demo

## Eureka-Server Eureka服务器启动项
#### Eureka:spring-cloud中起服务发现作用，其他服务需在该服务中注册

## Hystrix-Server 断路板,监视服务断路状态,被监视的服务需添加actuator依赖
#### 本次使用的单个服务的监视，也可以针对Eureka上的一个application的所有实例做监视，需要(turbine相关依赖)

## test-service-1，test-service-2 注册于Eureka上的服务

## test-client 用于访问注册在Eureka上的服务
#### Ribbon:结合eureka，对其注册的同一个application.name下的所有实例(即服务)做负载均衡  在spring-cloud-eureka中封装于RestTemplate中(以前封装于RestTemplate的requestFactory中，Brixton.SR3之后的版本封装于interceptor中)
#### Hystrix:隔断机制，当产生错误时启用备用方案
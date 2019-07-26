# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#production-ready)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#configuration-metadata-annotation-processor)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

# 获取token
http://192.168.0.102/auth-server/oauth/token?grant_type=password&username=user&password=pass
# 刷新token
http://192.168.0.102/auth-server/oauth/token?grant_type=refresh_token&refresh_token=
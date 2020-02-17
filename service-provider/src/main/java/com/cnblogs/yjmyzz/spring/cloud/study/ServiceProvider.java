package com.cnblogs.yjmyzz.spring.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by yangjunming on 2017/6/17.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableAsync
public class ServiceProvider {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider.class, args);
    }
}

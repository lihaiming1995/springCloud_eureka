package com.example.springcloud_1_eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class Springcloud1EurekaclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud1EurekaclientApplication.class, args);
    }

}

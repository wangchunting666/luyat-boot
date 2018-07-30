package com.ly.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Herdsric-M-003 on 2018/7/12.
 */
@EnableFeignClients
@SpringBootApplication
public class Application {
    public static void main(String[] args){SpringApplication.run(Application.class,args);}
}

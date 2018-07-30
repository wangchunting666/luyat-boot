package com.ly.ams;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Herdsric-M-003 on 2018/7/12.
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.ly.ams.dao","com.ly.ams.service","com.ly.ams.web","com.ly.ams.app"})
@MapperScan("com.ly.ams.dao")
public class Application {
    public static void main(String[] args){SpringApplication.run(Application.class,args);}
}

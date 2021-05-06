package com.yntx.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.yntx"})
@EnableSwagger2
@EnableFeignClients
public class EduApp {

    public static void main(String[] args) {
        SpringApplication.run(EduApp.class,args);
    }
}

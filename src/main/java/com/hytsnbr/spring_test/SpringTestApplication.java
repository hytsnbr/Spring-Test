package com.hytsnbr.spring_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hytsnbr")
public class SpringTestApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }
}

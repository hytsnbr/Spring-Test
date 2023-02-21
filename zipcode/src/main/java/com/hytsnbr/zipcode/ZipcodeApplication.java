package com.hytsnbr.zipcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan(value = "com.hytsnbr.base_common.config.property")
@SpringBootApplication
public class ZipcodeApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ZipcodeApplication.class, args);
    }
}

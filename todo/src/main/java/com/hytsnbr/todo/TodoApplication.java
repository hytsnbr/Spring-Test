package com.hytsnbr.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@ConfigurationPropertiesScan(value = "com.hytsnbr.base_common.config.property")
@SpringBootApplication
public class TodoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }
}

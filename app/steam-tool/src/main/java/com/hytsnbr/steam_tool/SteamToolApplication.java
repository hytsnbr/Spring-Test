package com.hytsnbr.steam_tool;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import com.hytsnbr.steam_tool.service.GeneratorService;

@ConfigurationPropertiesScan(value = "com.hytsnbr.base_common.config.property")
@SpringBootApplication(scanBasePackages = {
    "com.hytsnbr.base_common",
    "com.hytsnbr.steam",
    "com.hytsnbr.steam_tool"
})
public class SteamToolApplication implements CommandLineRunner {
    
    private final GeneratorService generatorService;
    
    public SteamToolApplication(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SteamToolApplication.class);
    }
    
    @Override
    public void run(String... args) throws Exception {
        generatorService.generate();
    }
}
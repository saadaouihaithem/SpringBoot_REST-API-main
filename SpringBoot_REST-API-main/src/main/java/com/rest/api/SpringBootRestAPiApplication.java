package com.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.rest.api.repositories")//to scan repository files
@EntityScan("com.rest.api.entity")
@EnableJpaRepositories("com.rest.api.repository")
public class SpringBootRestAPiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestAPiApplication.class, args);
    }



}

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class using @SpringBootApplication annotation.
 * This annotation is a convenience annotation that adds all of the following:
 * - @Configuration: Indicates this class defines Spring Configuration
 * - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings
 * - @ComponentScan: Tells Spring to look for other components, configurations, and services in the base package
 */
@SpringBootApplication
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearningApplication.class, args);
    }
}

package com.example.service;

import org.springframework.stereotype.Service;

/**
 * Sample service class using @Service annotation.
 * @Service is a specialization of @Component, used to mark the class as a service layer component.
 */
@Service
public class GreetingService {

    /**
     * Returns a greeting message.
     * @param name the name to greet
     * @return greeting message
     */
    public String getGreeting(String name) {
        return "Hello, " + name + "! Welcome to Spring Boot Learning.";
    }

    /**
     * Returns the application status.
     * @return status message
     */
    public String getStatus() {
        return "Application is running successfully!";
    }
}

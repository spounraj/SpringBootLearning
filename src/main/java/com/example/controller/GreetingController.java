package com.example.controller;

import com.example.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

/**
 * Sample REST controller using @RestController annotation.
 * @RestController is a convenience annotation that combines @Controller and @ResponseBody.
 */
@Slf4j
@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

    /**
     * Using @Autowired annotation for dependency injection.
     * This tells Spring to inject the GreetingService bean into this field.
     */
    @Autowired
    private GreetingService greetingService;

    /**
     * Sample GET endpoint using @GetMapping annotation.
     * @param name the name to greet (default value is "User")
     * @return greeting message
     */
    @GetMapping
    public ResponseEntity<String> greet(
            @RequestParam(defaultValue = "User") String name) {
        log.info("Greeting requested for name={}", name);
        String greeting = greetingService.getGreeting(name);
        log.info("Returning greeting: {}", greeting);
        return ResponseEntity.ok(greeting);
    }

    /**
     * Sample GET endpoint to check application status.
     * @return status message
     */
    @GetMapping("/status")
    public ResponseEntity<String> status() {
        String status = greetingService.getStatus();
        log.info("Status requested, returning: {}", status);
        return ResponseEntity.ok(status);
    }
}

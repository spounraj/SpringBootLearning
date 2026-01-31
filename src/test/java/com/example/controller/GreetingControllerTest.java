package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

/**
 * Spring Boot Test class for GreetingController using JUnit5 and annotations.
 *
 * Key Annotations:
 * - @SpringBootTest: Loads the full application context for integration testing
 * - @AutoConfigureMockMvc: Auto-configures MockMvc for testing web layer
 * - @Test: Marks a method as a test method (JUnit5)
 * - @DisplayName: Provides a custom display name for test methods
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("GreetingController Tests")
public class GreetingControllerTest {

    /**
     * MockMvc is used to test Spring MVC controllers without starting a server.
     * Injected using @Autowired annotation.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Setup method executed before each test using @BeforeEach annotation.
     */
    @BeforeEach
    public void setUp() {
        // Any setup logic can go here
    }

    /**
     * Test the /greeting endpoint with default parameter.
     */
    @Test
    @DisplayName("Should return greeting with default name")
    public void testGreetingEndpointWithDefaultName() throws Exception {
        mockMvc.perform(get("/springboot-learning/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")))
                .andExpect(content().string(containsString("User")));
    }

    /**
     * Test the /greeting endpoint with custom name parameter.
     */
    @Test
    @DisplayName("Should return greeting with custom name")
    public void testGreetingEndpointWithCustomName() throws Exception {
        mockMvc.perform(get("/springboot-learning/greeting?name=Spring"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Spring")))
                .andExpect(content().string(containsString("Welcome")));
    }

    /**
     * Test the /status endpoint.
     */
    @Test
    @DisplayName("Should return application status")
    public void testStatusEndpoint() throws Exception {
        mockMvc.perform(get("/springboot-learning/greeting/status"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("running")));
    }

    /**
     * Test the /greeting endpoint with various names.
     */
    @Test
    @DisplayName("Should handle multiple names in greeting endpoint")
    public void testGreetingEndpointWithMultipleNames() throws Exception {
        String[] names = {"Alice", "Bob", "Charlie"};

        for (String name : names) {
            mockMvc.perform(get("/springboot-learning/greeting?name=" + name))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString(name)));
        }
    }
}

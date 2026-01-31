package com.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Spring Boot Test class for GreetingService using JUnit5 and annotations.
 *
 * Key Annotations:
 * - @SpringBootTest: Loads the full application context for integration testing
 * - @Test: Marks a method as a test method (JUnit5)
 * - @BeforeEach: Runs before each test method
 * - @DisplayName: Provides a custom display name for test methods
 */
@SpringBootTest
@DisplayName("GreetingService Tests")
public class GreetingServiceTest {

    /**
     * Using @Autowired to inject the GreetingService bean for testing.
     */
    @Autowired
    private GreetingService greetingService;

    /**
     * Setup method executed before each test using @BeforeEach annotation.
     */
    @BeforeEach
    public void setUp() {
        assertNotNull(greetingService, "GreetingService should be injected");
    }

    /**
     * Test to verify the service bean is not null.
     */
    @Test
    @DisplayName("Should load GreetingService bean")
    public void testServiceBeanLoaded() {
        assertThat(greetingService).isNotNull();
    }

    /**
     * Test to verify the getGreeting method returns correct greeting.
     */
    @Test
    @DisplayName("Should return correct greeting message")
    public void testGetGreeting() {
        // Arrange
        String name = "John";

        // Act
        String result = greetingService.getGreeting(name);

        // Assert
        assertThat(result)
                .isNotNull()
                .contains("Hello")
                .contains(name)
                .isEqualTo("Hello, John! Welcome to Spring Boot Learning.");
    }

    /**
     * Test to verify the getStatus method returns status message.
     */
    @Test
    @DisplayName("Should return application status")
    public void testGetStatus() {
        // Act
        String status = greetingService.getStatus();

        // Assert
        assertThat(status)
                .isNotNull()
                .isNotEmpty()
                .contains("running");
    }

    /**
     * Test to verify the getGreeting method handles different names.
     */
    @Test
    @DisplayName("Should handle multiple names correctly")
    public void testGetGreetingWithMultipleNames() {
        // Arrange
        String[] names = {"Alice", "Bob", "Charlie"};

        // Act & Assert
        for (String name : names) {
            String result = greetingService.getGreeting(name);
            assertThat(result)
                    .contains("Hello")
                    .contains(name);
        }
    }
}

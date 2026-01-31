# Spring Boot Learning Project

A basic Spring Boot learning project demonstrating annotation-based configuration with sample endpoints and comprehensive test cases using JUnit5.

## Project Structure

```
src/
├── main/
│   ├── java/com/example/
│   │   ├── SpringBootLearningApplication.java    # Main Spring Boot Application
│   │   ├── controller/
│   │   │   └── GreetingController.java           # REST Controller
│   │   └── service/
│   │       └── GreetingService.java              # Service Layer
│   └── resources/
│       └── application.properties                 # Application Configuration
└── test/
    └── java/com/example/
        ├── controller/
        │   └── GreetingControllerTest.java       # Controller Tests (JUnit5)
        └── service/
            └── GreetingServiceTest.java          # Service Tests (JUnit5)
```

## Technology Stack

- **Java**: 17
- **Spring Boot**: 3.2.0
- **Maven**: Build tool
- **JUnit5 (Jupiter)**: Testing framework
- **AssertJ**: Fluent assertions library

## Key Annotations Used

### Main Application
- `@SpringBootApplication`: Main application annotation combining @Configuration, @EnableAutoConfiguration, and @ComponentScan

### Controller Layer
- `@RestController`: Marks the class as a REST controller
- `@RequestMapping`: Maps HTTP requests to handler methods
- `@GetMapping`: Shortcut for @RequestMapping with GET method
- `@RequestParam`: Binds query parameters to method parameters
- `@Autowired`: Dependency injection annotation

### Service Layer
- `@Service`: Marks the class as a service component

### Testing
- `@SpringBootTest`: Loads the full application context for integration testing
- `@AutoConfigureMockMvc`: Auto-configures MockMvc for testing web layer
- `@Test`: Marks a method as a test method (JUnit5)
- `@BeforeEach`: Runs before each test method
- `@DisplayName`: Provides custom display names for test methods

## Building the Project

```bash
mvn clean install
```

## Running the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### 1. Greeting Endpoint (with default name)
```bash
curl http://localhost:8080/api/greeting
```
Response: `Hello, User! Welcome to Spring Boot Learning.`

### 2. Greeting Endpoint (with custom name)
```bash
curl "http://localhost:8080/api/greeting?name=John"
```
Response: `Hello, John! Welcome to Spring Boot Learning.`

### 3. Status Endpoint
```bash
curl http://localhost:8080/api/greeting/status
```
Response: `Application is running successfully!`

## Running Tests

### Run all tests
```bash
mvn test
```

### Run specific test class
```bash
mvn test -Dtest=GreetingServiceTest
```

### Run with verbose output
```bash
mvn test -e
```

## Test Coverage

The project includes comprehensive test cases demonstrating:

### GreetingServiceTest (Service Layer Testing)
- `@SpringBootTest` for application context loading
- `@Autowired` for dependency injection
- `@BeforeEach` for test setup
- `@DisplayName` for test descriptions
- AssertJ fluent assertions
- Business logic validation

### GreetingControllerTest (Controller Layer Testing)
- `@SpringBootTest` with `@AutoConfigureMockMvc`
- MockMvc for HTTP endpoint testing
- GET request testing
- Response status and content validation
- Multiple parameter scenarios

## Application Properties

The `application.properties` file includes:
- Server port configuration
- Context path configuration
- Logging levels and patterns
- Application metadata

## Learning Objectives

This project demonstrates:
1. Spring Boot application setup with Maven
2. Annotation-based configuration (no XML)
3. Dependency injection with `@Autowired`
4. REST controller development
5. Service layer implementation
6. JUnit5 integration testing
7. MockMvc for web layer testing
8. AssertJ for fluent assertions
9. Test lifecycle management with `@BeforeEach`
10. Custom test display names with `@DisplayName`

## Requirements

- Java 17+
- Maven 3.6.0+

## License

MIT License

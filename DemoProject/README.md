# API Testing Framework Documentation

## Overview
This framework is designed for automated API testing with a focus on best practices, maintainability, and extensibility. It supports:

- Coverage for edge cases (negative testing, boundary testing, error scenarios, and authorization testing).
- Parameterized and data-driven tests.
- JSON schema validation and field-level assertions.
- Modular design for easy test maintenance and scalability.

---

## Project Structure
```
src
├── main
│   └── java
│       └── com
│           └── company
│               ├── api
│               │   └── PostApiClient.java
│               └── utils
│                   └── FileUtils.java
├── test
    └── java
        └── com
            └── company
                └── tests
                    ├── edgecases
                    │   ├── NegativeTests.java
                    │   ├── BoundaryTests.java
                    │   ├── ErrorScenarioTests.java
                    │   └── AuthorizationTests.java
                    ├── parameterized
                    │   ├── ResponseCodeTests.java
                    │   └── DataDrivenTests.java
                    └── validation
                        ├── JsonSchemaValidationTests.java
                        └── FieldValidationTests.java
resources
└── schemas
    └── getAllPostsSchema.json
```

---

## Key Features
### 1. Edge Case Testing
Focuses on testing scenarios like invalid inputs, boundary conditions, and error handling.
- Examples: Invalid data types, missing fields, backend failures, and authorization checks.

### 2. Parameterized Tests
Runs the same test logic with multiple data sets using TestNG's `DataProvider`.
- Benefits: Reduces redundancy and ensures comprehensive test coverage.

### 3. JSON Schema Validation
Ensures response structure adheres to a predefined schema.
- Tools: Uses RestAssured’s JSON Schema Validator module.

### 4. Modular Utilities
Utility methods like `FileUtils` for common tasks (e.g., saving responses to files).

---

## Installation
### Prerequisites
- **Java**: Ensure JDK 8 or higher is installed.
- **Maven**: Ensure Maven is installed and configured.
- **TestNG**: Included as a dependency in the `pom.xml` file.

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/marcusqatech/api-testing-framework-junit.git
   cd api-testing-framework-junit
   ```
2. Install dependencies:
   ```bash
   mvn clean install
   ```

---

## Usage
### Running Tests
To run all tests:
```bash
mvn test
```

To run specific test classes:
```bash
mvn test -Dtest=NegativeTests
```

### Generating Reports
HTML test reports can be generated with Maven Surefire:
```bash
mvn surefire-report:report
```

---

## Adding New Tests
### Steps
1. Identify the test category (e.g., edge case, parameterized, or validation).
2. Add a new test class in the appropriate folder.
3. Use utilities and APIs from the `utils` and `api` packages to streamline implementation.
4. Add appropriate assertions and logging.

### Example: Adding a New Test
#### File: `NegativeTests.java`
```java
@Test
public void testInvalidFieldType() {
    Response response = apiClient.createPost("Test Title", 12345, 1); // Invalid body type
    Assert.assertEquals(response.getStatusCode(), 400);
    Assert.assertTrue(response.getBody().asString().contains("body must be a string"));
}
```

---

## Best Practices
- **Organize Tests**: Follow the folder structure to separate concerns.
- **Validate Beyond Status Codes**: Use JSON schema validation and field-specific assertions.
- **Log All Results**: Ensure all request/response pairs are logged for debugging.
- **Parameterize Tests**: Use data-driven tests for comprehensive input coverage.
- **Maintain Modularity**: Keep utility methods reusable and concise.

---

## Dependencies
```xml
<dependencies>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.7.0</version>
    </dependency>
</dependencies>
```

---

## Contribution Guidelines
1. Fork the repository and create a feature branch.
2. Follow the established folder and test naming conventions.
3. Run all tests and ensure they pass before creating a pull request.

---

## Contact
For questions or suggestions, please contact:
- **Name**: Marcus Cruz
- **Email**: marcusfunctional01@gmail.com
- **GitHub**: https://github.com/marcusqatech

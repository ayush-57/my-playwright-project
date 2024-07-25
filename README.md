# Playwright Java TestNG Project

This project is a sample automation framework using Playwright with Java and TestNG. It demonstrates some sample login test cases, reading configuration from a properties file, and maintain a clean code structure.

## Files Descriptions

- `pom.xml`: Maven configuration file, including dependencies and plugins.
- `LoginPage.java`: Page Object Model for the login page, containing methods to interact with the login elements.
- `LoginTests.java`: TestNG test class containing test methods for login functionality.
- `config.properties`: Configuration file containing login credentials and URLs.
- `ConfigReader.java`: Utility class for reading properties from `config.properties`.

### Installing

1. Clone the repository
2. Install Maven dependencies:  mvn clean install
    
### Running the Tests

To run all tests, execute the following command: mvn test

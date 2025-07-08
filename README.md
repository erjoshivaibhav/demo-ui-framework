# Demo UI Framework

## Overview
This project is a Selenium-based UI automation framework written in Java. It is designed to automate web application testing using the Page Object Model (POM) design pattern. The framework is built with Maven for dependency management and supports cross-browser testing.

## Features
- **Page Object Model (POM):** Clean separation of test logic and page-specific actions.
- **Reusable Utilities:** Common browser utilities for interacting with web elements.
- **Cross-Browser Support:** Easily configurable for different browsers.
- **Scalable Design:** Modular structure for adding new pages and tests.

## Project Structure
    demo-ui-framework/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   ├── com/
    │   │   │   │   └── example/
    │   │   │   │       ├── pages/          # Page Object classes
    │   │   │   │       └── utils/          # Utility classes
    │   └── test/
    │       ├── java/
    │       │   └── com/
    │       │       └── example/
    │       │           └── tests/          # Test classes
    ├── pom.xml                            # Maven configuration file
    └── README.md                           # Project documentation
## Prerequisites
- Java 8 or higher
- Maven 3.6 or higher
- ChromeDriver or other browser drivers installed and added to PATH

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/demo-ui-framework.git# demo-ui-framework
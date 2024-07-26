# G2A Automation Testing Project

## Project Overview

This project contains an automated test scenario designed to verify the product price on the product details page and in the cart for an anonymous user on the G2A website.

## Prerequisites

- remote
    - Docker
    - Docker Compose
- local
    - java 11
    - git


## Setup Instructions
### Running Tests with Docker Compose

Clone the repository:

```bash
git clone <repository-url>
cd g2a-automation
```
Run the tests using Docker Compose with the product name environment variable:
```bash
PRODUCT_NAME="your-product-name" docker-compose up --build
```
### Accessing Selenium Grid and Test Report

- Selenium Grid: [http://localhost:4444](http://localhost:4444)
- Allure Test Report: [http://localhost:4040](http://localhost:4040) (will be available after test run)

### Running Tests Locally
- Run the tests with the product name parameter:
```bash
mvn clean test -DproductName="your-product-name" -DbrowserEnv="local"
```
### Allure Report Generation
After running the tests, an Allure report will be generated to provide detailed information about the test execution, including screenshots and step-by-step details.

To generate and serve the Allure report locally:

1. Ensure the tests have been run and the results are available in the target/allure-results directory.  
   Generate the Allure report:
```bash
mvn allure:report
```
Serve the Allure report on a local web server:
```bash
mvn allure:serve
```
The Allure report will be accessible at [http://localhost:4040](http://localhost:4040) by default.
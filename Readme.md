# ControlTowerApi

## Overview

This project is built using Jakarta EE with Jakarta imports, Spring Data JPA, and Spring MVC. Its for CV and its not a main product.

## Prerequisites

1. **Java Development Kit (JDK) 17** or later.
2. **Maven** (for building the project).
3. **Docker** (optional, if you intend to use Docker for running services).


## How to Run

1. **Clone the repository**:
   ```sh
   git clone https://github.com/yourusername/ControlTowerApi.git
   cd ControlTowerApi
   ```
2. **Build the project using Maven**:
   ```sh
   mvn clean install
   ```
3. **Run the application**:
   You can run the application using your preferred method:
   **a. Using the embedded server**:

   ```sh
   mvn spring-boot:run
   ```
   **b. Using Docker (optional)**:

   If you have Docker installed and want to run the application inside a container, you can use the provided Dockerfile:

   ```sh
   docker build -t controltowerapi:latest .
   docker run -p 8080:8080 controltowerapi:latest
   ```
4. **Access the application**:
   Open your web browser and navigate to `http://localhost:8080`. You should see the application running.


5. **Access Swagger Documentation**:
   The application includes Swagger for API documentation. To access the Swagger UI:
   Open your web browser and go to:
   ```sh
   http://localhost:8080/doc/swagger-ui/index.html
   ```
   Here you will find the interactive API documentation where you can explore and test the available endpoints.
## Author

- [sheymor21](https://github.com/sheymor21)
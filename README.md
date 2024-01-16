# AP Challenge Backend

## Introduction

Welcome to the backend component of the AP Challenge, a Java project built with Spring Boot. This backend includes features such as Spring Security, Hibernate, and Spring Data JPA, with authentication and authorization based on JWT Token.

## Technologies Used

- **Spring Boot:** A powerful framework for building Java-based enterprise applications.
- **Spring Security:** Provides authentication and access control for the application.
- **Hibernate:** An object-relational mapping (ORM) framework for Java.
- **Spring Data JPA:** Simplifies database access using the Java Persistence API (JPA).
- **JWT Token:** Authentication and authorization are based on JSON Web Tokens (JWT).
- **Maven:** Dependency management and project build tool.
- **MySQL:** Database used for storing application data.
- **XAMPP:** Recommended for establishing a connection to the MySQL database on port 3306.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed.
- Maven installed.
- XAMPP installed for MySQL.

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/ap-challenge-backend.git
    ```

2. Navigate to the project directory:

    ```bash
    cd ap-challenge-backend
    ```

3. Build and run the project using Maven:

    ```bash
    mvn spring-boot:run
    ```

### Database Configuration

1. Ensure XAMPP is running and MySQL is accessible on port 3306.
2. Update the database configuration in `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```
## Usage

The backend API is accessible at `http://localhost:8080`.

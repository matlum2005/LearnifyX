# LearnifyX Backend

A Spring Boot backend application for the LearnifyX e-learning platform.

## Features

- User registration and authentication
- Course enrollment management
- MySQL database integration
- RESTful API endpoints
- CORS support for frontend integration

## Technologies Used

- Java 17
- Spring Boot 3.1.0
- Spring Data JPA
- MySQL Database
- Maven

## Prerequisites

- Java 17 or higher
- MySQL Server
- Maven (or use the included Maven wrapper)

## Database Setup

1. Create a MySQL database named `testdb`
2. Update the database credentials in `src/main/resources/application.properties`:
   ```
   spring.datasource.username=root
   spring.datasource.password=8595629739
   ```

## Running the Application

1. Navigate to the backend directory:
   ```bash
   cd backend
   ```

2. Compile the project:
   ```bash
   mvn clean compile
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

   Or using the Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on `http://localhost:8080`

## API Endpoints

### User Management
- `POST /api/users` - User registration
- `POST /api/users/login` - User login

### Enrollment Management
- `GET /api/enrollments` - Get all enrollments
- `POST /api/enrollments?userId={id}&courseId={id}` - Enroll user in course
- `PUT /api/enrollments/{id}/complete` - Mark enrollment as completed

## Project Structure

```
backend/
├── src/main/java/com/learning/
│   ├── config/          # Configuration classes
│   ├── controller/      # REST controllers
│   ├── dto/            # Data Transfer Objects
│   ├── exception/      # Exception handlers
│   ├── model/          # JPA entities
│   ├── repository/     # Data repositories
│   └── service/        # Business logic services
├── src/main/resources/
│   ├── application.properties  # Application configuration
│   └── data.sql               # Sample data
└── pom.xml                    # Maven configuration
```

## Frontend Integration

The backend is designed to work with the LearnifyX frontend. Make sure the frontend is running on `http://localhost:3000` or update the CORS configuration in `application.properties`.

# LearnifyX - Modern E-Learning Platform

![LearnifyX](E-Learning-Website-HTML-CSS-main/preview.jpg)

LearnifyX is a comprehensive, full-stack e-learning platform designed to provide an interactive and user-friendly environment for online education. The platform connects students and instructors, offering a seamless learning experience with modern web technologies.

## 🚀 Features

### Frontend Features
- **Responsive Design**: Fully responsive layout using Bootstrap 5, optimized for all devices (desktop, tablet, mobile)
- **Course Catalog**: Comprehensive course listings with detailed descriptions, ratings, and pricing
- **User Authentication**: Login and signup functionality for personalized learning experiences
- **Interactive Elements**: Carousel sliders, animations, and dynamic content using JavaScript and libraries like Owl Carousel and WOW.js
- **Instructor Portal**: Dedicated section for instructors to apply and share their expertise
- **Contact & Support**: Contact forms and FAQ sections for user support
- **Multi-page Structure**: Includes pages for Home, About, Courses, Team, Testimonials, Contact, Login, Signup, and more
- **Modern UI/UX**: Clean, professional design with intuitive navigation and engaging visuals

### Backend Features
- **User Management**: Registration, authentication, and user profile management
- **Course Management**: CRUD operations for courses with instructor assignments
- **Enrollment System**: Course enrollment tracking and completion status
- **RESTful API**: Well-structured REST endpoints for frontend integration
- **Database Integration**: MySQL database with JPA/Hibernate ORM
- **Security**: Spring Security integration for authentication and authorization
- **CORS Support**: Cross-origin resource sharing for frontend-backend communication

## 🛠️ Technology Stack

### Frontend
- **HTML5**: Semantic markup for structure and accessibility
- **CSS3**: Custom styling with animations and responsive design
- **Bootstrap 5**: Framework for responsive grid system, components, and utilities
- **JavaScript**: Interactive functionality, form validation, and dynamic content
- **Libraries**:
  - Owl Carousel: For image and content carousels
  - WOW.js: For scroll animations
  - jQuery: For DOM manipulation and event handling
  - Font Awesome & Bootstrap Icons: For icons and visual elements

### Backend
- **Java 17**: Programming language
- **Spring Boot 3.1.0**: Framework for building REST APIs
- **Spring Data JPA**: For database operations
- **MySQL**: Relational database
- **Spring Security**: For authentication and authorization
- **Maven**: Build and dependency management

## 📋 Prerequisites

Before running this project, ensure you have:

### Frontend
- A modern web browser (Chrome, Firefox, Safari, Edge)
- A text editor or IDE (e.g., Visual Studio Code, Sublime Text)

### Backend
- **Java 17** or higher
- **MySQL Server** (version 8.0 or higher)
- **Maven** (or use the included Maven wrapper)

## 🚀 Getting Started

### Database Setup

1. **Install MySQL Server** and start the MySQL service
2. **Create Database**:
   ```sql
   CREATE DATABASE testdb;
   ```
3. **Update Database Credentials** (if different from default):
   - Open `backend/src/main/resources/application.properties`
   - Update the following properties:
     ```properties
     spring.datasource.username=your_mysql_username
     spring.datasource.password=your_mysql_password
     ```

### Backend Setup

1. **Navigate to Backend Directory**:
   ```bash
   cd backend
   ```

2. **Install Dependencies**:
   ```bash
   mvn clean install
   ```

3. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```
   Or using the Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```

   The backend will start on `http://localhost:8080`

### Frontend Setup

1. **Navigate to Frontend Directory**:
   ```bash
   cd E-Learning-Website-HTML-CSS-main
   ```

2. **Open in Browser**:
   - Open `index.html` in your preferred web browser
   - Alternatively, use a local server for better performance (e.g., Live Server extension in VS Code)

## 📡 API Endpoints

### User Management
- `POST /api/users` - User registration
- `POST /api/users/login` - User login

### Enrollment Management
- `GET /api/enrollments` - Get all enrollments
- `POST /api/enrollments?userId={id}&courseId={id}` - Enroll user in course
- `PUT /api/enrollments/{id}/complete` - Mark enrollment as completed

### Sample API Usage

#### User Registration
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@example.com",
    "password": "password123"
  }'
```

#### User Login
```bash
curl -X POST http://localhost:8080/api/users/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john@example.com",
    "password": "password123"
  }'
```

#### Enroll in Course
```bash
curl -X POST "http://localhost:8080/api/enrollments?userId=1&courseId=1"
```

## 📁 Project Structure

```
LearnifyX-main/
├── E-Learning-Website-HTML-CSS-main/     # Frontend Application
│   ├── index.html                        # Home page
│   ├── about.html                        # About Us page
│   ├── courses.html                      # Courses catalog
│   ├── contact.html                      # Contact page
│   ├── login.html                        # Login page
│   ├── signup.html                       # Signup page
│   ├── instructor.html                   # Instructor application
│   ├── team.html                         # Our Team page
│   ├── testimonial.html                  # Testimonials page
│   ├── single.html                       # Individual course page
│   ├── css/
│   │   ├── bootstrap.min.css             # Bootstrap CSS
│   │   └── style.css                     # Custom styles
│   ├── js/
│   │   └── main.js                       # Custom JavaScript
│   ├── lib/                              # Third-party libraries
│   ├── img/                              # Images and assets
│   ├── scss/                             # SCSS source files
│   └── readme.md                         # Frontend README
├── backend/                              # Backend Application
│   ├── src/main/java/com/learning/
│   │   ├── LearnifyxBackendApplication.java  # Main application class
│   │   ├── config/                        # Configuration classes
│   │   │   ├── SecurityConfig.java        # Security configuration
│   │   │   └── WebConfig.java             # Web configuration
│   │   ├── controller/                    # REST controllers
│   │   │   ├── UserController.java        # User management endpoints
│   │   │   └── EnrollmentController.java  # Enrollment management endpoints
│   │   ├── dto/                           # Data Transfer Objects
│   │   │   ├── UserDTO.java               # User data transfer object
│   │   │   ├── LoginRequest.java          # Login request DTO
│   │   │   └── SignupRequest.java         # Signup request DTO
│   │   ├── exception/                     # Exception handlers
│   │   │   └── GlobalExceptionHandler.java # Global exception handling
│   │   ├── model/                         # JPA entities
│   │   │   ├── User.java                  # User entity
│   │   │   ├── Course.java                # Course entity
│   │   │   └── Enrollment.java            # Enrollment entity
│   │   ├── repository/                    # Data repositories
│   │   │   ├── UserRepository.java        # User data access
│   │   │   ├── CourseRepository.java      # Course data access
│   │   │   └── EnrollmentRepository.java  # Enrollment data access
│   │   └── service/                       # Business logic services
│   │       ├── UserService.java           # User business logic
│   │       └── EnrollmentService.java     # Enrollment business logic
│   ├── src/main/resources/
│   │   ├── application.properties         # Application configuration
│   │   └── data.sql                       # Sample data
│   ├── pom.xml                            # Maven configuration
│   └── README.md                          # Backend README
├── TODO.md                                # Project tasks and progress
└── README.md                              # This file
```

## 🎯 Key Sections

### Frontend Pages
- **Home Page**: Hero carousel, service highlights, featured courses, and call-to-action banners
- **Courses Page**: Grid layout of available courses with filters and search capabilities
- **About Page**: Company mission, vision, and team information
- **Contact Page**: Contact form, FAQ accordion, and contact details
- **Authentication**: Login and signup forms with basic validation

### Backend Architecture
- **Layered Architecture**: Clear separation of concerns with controllers, services, and repositories
- **Entity Relationships**: User-Course-Enrollment relationships with proper JPA mappings
- **RESTful Design**: Standard HTTP methods and status codes
- **Error Handling**: Global exception handling with meaningful error messages

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. **Fork the Repository**
2. **Create a Feature Branch**:
   ```bash
   git checkout -b feature/AmazingFeature
   ```
3. **Commit Your Changes**:
   ```bash
   git commit -m 'Add some AmazingFeature'
   ```
4. **Push to the Branch**:
   ```bash
   git push origin feature/AmazingFeature
   ```
5. **Open a Pull Request**

### Development Guidelines
- Follow the existing code style and structure
- Write clear, concise commit messages
- Test your changes thoroughly
- Update documentation as needed

## 📞 Contact

- **Email**: khantausif9997@gmail.com
- **Phone**: +91 8595629739
- **Address**: 123 Street, Dasna, Ghaziabad

## 📜 License

This project is free to use and does not contain any specific license. Feel free to modify and distribute as needed.

## 🙏 Acknowledgments

- **Bootstrap** for the responsive framework
- **Spring Boot** for the robust backend framework
- **Font Awesome** for icons
- **Owl Carousel** for carousel functionality
- **WOW.js** for animations

---

**Give this project a ⭐️ if you found it helpful!**

For more details about specific components, check the individual README files in the `E-Learning-Website-HTML-CSS-main/` and `backend/` directories.

-- Sample Courses
INSERT INTO courses (title, description, instructor, price, created_at, updated_at) VALUES
('Introduction to Java Programming', 'Learn the basics of Java programming language', 'John Doe', 49.99, NOW(), NOW()),
('Web Development with Spring Boot', 'Build web applications using Spring Boot framework', 'Jane Smith', 79.99, NOW(), NOW()),
('Database Design and MySQL', 'Master database design and MySQL queries', 'Bob Johnson', 39.99, NOW(), NOW()),
('Frontend Development with React', 'Create modern web interfaces with React', 'Alice Brown', 59.99, NOW(), NOW()),
('Data Structures and Algorithms', 'Essential algorithms and data structures', 'Charlie Wilson', 69.99, NOW(), NOW());

-- Sample User (password: password123)
INSERT INTO users (name, email, password, created_at, updated_at)
VALUES ('Test User', 'test@example.com',
'$2a$10$DowJYYrjYAw78Cja07OrGehWfQKNpjDm8bQlWmYQvlXCCOXcM1Pny',
NOW(), NOW());

package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.model.Course;
import com.learning.model.Enrollment;
import com.learning.model.User;
import com.learning.repository.CourseRepository;
import com.learning.repository.EnrollmentRepository;
import com.learning.repository.UserRepository;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Enrollment> getEnrollmentsByUserId(Long userId) {
        return enrollmentRepository.findByUserId(userId);
    }

    public Enrollment enrollUserInCourse(Long userId, Long courseId) {
        if (enrollmentRepository.existsByUserIdAndCourseId(userId, courseId)) {
            throw new RuntimeException("User is already enrolled in this course");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment(user, course);
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment markAsCompleted(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        enrollment.setIsCompleted(true);
        return enrollmentRepository.save(enrollment);
    }
}

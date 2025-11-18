package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.Enrollment;
import com.learning.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // ✅ Enroll in a course
    @PostMapping("/enroll")
    public ResponseEntity<?> enroll(@RequestParam Long userId, @RequestParam Long courseId) {
        try {
            Enrollment enrollment = enrollmentService.enrollUserInCourse(userId, courseId);
            return ResponseEntity.ok(enrollment);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ✅ Get all enrollments of a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Enrollment>> getUserEnrollments(@PathVariable Long userId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByUserId(userId);
        return ResponseEntity.ok(enrollments);
    }

    // ✅ Mark course as completed
    @PutMapping("/complete/{enrollmentId}")
    public ResponseEntity<?> markCompleted(@PathVariable Long enrollmentId) {
        try {
            Enrollment updated = enrollmentService.markAsCompleted(enrollmentId);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

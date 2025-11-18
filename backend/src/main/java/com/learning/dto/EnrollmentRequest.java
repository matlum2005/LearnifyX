package com.learning.dto;

import jakarta.validation.constraints.NotNull;

public class EnrollmentRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Course ID is required")
    private Long courseId;

    // ✅ Default Constructor
    public EnrollmentRequest() {}

    // ✅ Parameterized Constructor
    public EnrollmentRequest(Long userId, Long courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    // ✅ Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}

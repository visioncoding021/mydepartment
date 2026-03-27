package com.rgoswami3414.mydepartment.Dtos;

import com.rgoswami3414.mydepartment.Utils.PhoneNoValidator;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

public class Dtos {

    // ========================= REQUEST DTOs =========================

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestEmployee {

        @NotBlank(message = "First name is required")
        private String firstName;

        @NotBlank(message = "Last name is required")
        private String lastName;

        @Email(message = "Invalid email format")
        @NotBlank(message = "Email is required")
        private String email;

        @PhoneNoValidator
        private String phoneNo;

        @Min(value = 0, message = "Experience cannot be negative")
        @Max(value = 80, message = "Experience cannot exceed 80 years")
        private int experience;

        @Min(value = 18, message = "Age must be at least 18")
        @Max(value = 100, message = "Age cannot exceed 100")
        private int age;

        private Long managerId;
        private Integer departmentId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestDepartment {

        @NotBlank(message = "Department name is required")
        @Size(min = 3, max = 50, message = "Department name must be between 3 and 50 characters")
        private String departmentName;

        @NotBlank(message = "Location is required")
        private String location;

        private String specification;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestSalary {

        @NotNull(message = "Employee ID is required")
        private Long employeeId;

        @Positive(message = "Salary amount must be greater than 0")
        private double amount;

        @NotNull(message = "Effective date is required")
        private LocalDateTime effectiveDate;
    }

    // ========================= RESPONSE DTOs =========================

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseEmployee {

        private long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNo;
        private int experience;
        private int age;
        private long managerId;
        private int departmentId;
        private LocalDateTime dateOfJoining;
        private LocalDateTime createdAt;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseDepartment {

        private Long id;
        private String departmentName;
        private String location;
        private String specification;
        private LocalDateTime createdAt;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseSalary {

        private long id;
        private long employeeId;
        private double amount;
        private LocalDateTime effectiveDate;
    }

    // ========================= COMMON RESPONSE =========================

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ApiResponse<T> {
        private T data;
        private ApiError error;
        private LocalDateTime responseTime;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApiError {
        private String message;     // User-friendly message
        private int status;         // HTTP status code
        private String errorCode;   // Internal error code (for debugging)
    }
}
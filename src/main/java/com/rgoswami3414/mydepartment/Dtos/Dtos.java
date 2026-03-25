package com.rgoswami3414.mydepartment.Dtos;

import com.rgoswami3414.mydepartment.Model.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

public class Dtos {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestEmployee{
        @NotBlank
        @NotNull
        private String firstName;
        @NotBlank
        private String lastName;
        @Email
        private String email;

        private String phoneNo;
        private int experience;
        private int age;
        private long manager_id;
        private int department_id;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestDepartment{
        private String departmentName;
        private String location;
        private String specification;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestSalary{
        private long employee_id;
        private double amount;
        private LocalDateTime effective_date;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseEmployee{
        private long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNo;
        private int experience;
        private int age;
        private long manager_id;
        private int department_id;
        private LocalDateTime dateOfJoining;
        private LocalDateTime createdAt;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseDepartment{
        private int id;
        private String departmentName;
        private String location;
        private String specification;
        private LocalDateTime createdAt;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseSalary{
        private long id;
        private long employee_id;
        private double amount;
        private LocalDateTime effective_date;
    }
@Data
@AllArgsConstructor
@NoArgsConstructor
    public static class ApiResponse<T>{
       private T data;
      private ApiError apiError;
      private LocalDateTime responseTime;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ApiError {
        private String message;
        private int code;
    }
}

package com.rgoswami3414.mydepartment.Controller;

import com.rgoswami3414.mydepartment.Dtos.Dtos.*;
import com.rgoswami3414.mydepartment.Service.DepartmentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/departments")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ResponseDepartment>> createDepartment(
            @Valid @RequestBody RequestDepartment requestDepartment) {

        log.info("Creating department: {}", requestDepartment.getDepartmentName());

        ResponseDepartment data = departmentService.createDepartment(requestDepartment);

        ApiResponse<ResponseDepartment> response = ApiResponse.<ResponseDepartment>builder()
                .data(data)
                .responseTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
package com.rgoswami3414.mydepartment.Controller;

import com.rgoswami3414.mydepartment.Dtos.Dtos.*;
import com.rgoswami3414.mydepartment.Service.DepartmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ResponseDepartment>>> getAllDepartment(
            @RequestParam(defaultValue = "0")@Min(0) int page,
            @RequestParam(defaultValue = "5")@Max(100) int size){
      log.info("Getting all department : ");
      List<ResponseDepartment> data = departmentService.getAllDepartment(page,size);
      ApiResponse<List<ResponseDepartment>> response = ApiResponse.<List<ResponseDepartment>>builder()
              .data(data)
              .responseTime(LocalDateTime.now())
              .error(null)
              .build();
              return  ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ResponseDepartment>> getDepartment(@RequestParam int id){
        ResponseDepartment data = departmentService.getDepartment(id);
        ApiResponse<ResponseDepartment> response = ApiResponse.<ResponseDepartment>builder()
                                                              .data(data)
                .responseTime(LocalDateTime.now())
                .error(null)
                .build();
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update")
    public ResponseEntity<ApiResponse<ResponseDepartment>> updateDepartment(@RequestBody UpdateDepartment requestDepartment){
        ResponseDepartment data = departmentService.updateDepartment(requestDepartment);
        ApiResponse<ResponseDepartment> response = ApiResponse.<ResponseDepartment>builder()
                .data(data)
                .responseTime(LocalDateTime.now())
                .error(null)
                .build();
                return ResponseEntity.ok(response);
    }
}
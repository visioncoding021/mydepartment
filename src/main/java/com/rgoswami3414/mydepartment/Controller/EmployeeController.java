package com.rgoswami3414.mydepartment.Controller;

import com.rgoswami3414.mydepartment.Dtos.Dtos.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @GetMapping("/add")
    public ResponseEntity<ResponseEmployee> CreateEmployee(@Valid  @RequestBody RequestEmployee employee){
            return ResponseEntity.ok(null);
        }
}

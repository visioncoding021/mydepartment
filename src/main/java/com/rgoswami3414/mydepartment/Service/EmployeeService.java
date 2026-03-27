package com.rgoswami3414.mydepartment.Service;

import com.rgoswami3414.mydepartment.Dtos.Dtos.*;
import com.rgoswami3414.mydepartment.Model.Employee;
import com.rgoswami3414.mydepartment.Repository.DepartmentRepo;
import com.rgoswami3414.mydepartment.Repository.EmployeeRepo;
import com.rgoswami3414.mydepartment.Repository.SalaryRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements EmployeeInfra{
    final private DepartmentRepo departmentRepo;
    final private EmployeeRepo employeeRepo;
    final private SalaryRepo salaryRepo;
    public EmployeeService(DepartmentRepo departmentRepo, EmployeeRepo employeeRepo, SalaryRepo salaryRepo){
        this.departmentRepo = departmentRepo;
        this.employeeRepo = employeeRepo;
        this.salaryRepo = salaryRepo;
    }

    public ResponseEmployee createEmploye(RequestEmployee requestEmployee){
        Employee employee = null;

//        employeeRepo.save(employee);
        return null;
    }
}

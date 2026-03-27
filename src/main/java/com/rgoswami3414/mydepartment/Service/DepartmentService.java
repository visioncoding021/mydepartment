package com.rgoswami3414.mydepartment.Service;

import com.rgoswami3414.mydepartment.Dtos.Dtos.*;
import com.rgoswami3414.mydepartment.Model.Department;
import com.rgoswami3414.mydepartment.Repository.DepartmentRepo;
import com.rgoswami3414.mydepartment.Repository.EmployeeRepo;
import com.rgoswami3414.mydepartment.Repository.SalaryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements DepartmentInfra{

    final private DepartmentRepo departmentRepo;
    final private EmployeeRepo employeeRepo;
    final private SalaryRepo salaryRepo;
    final private ModelMapper modelMapper;
    public DepartmentService(DepartmentRepo departmentRepo, EmployeeRepo employeeRepo, SalaryRepo salaryRepo,ModelMapper modelMapper){
        this.departmentRepo = departmentRepo;
        this.employeeRepo = employeeRepo;
        this.salaryRepo = salaryRepo;
        this.modelMapper = modelMapper;
    }

    public ResponseDepartment createDepartment(RequestDepartment requestDepartment){
        Department department = modelMapper.map(requestDepartment,Department.class);
       department = departmentRepo.save(department);
        return modelMapper.map(department,ResponseDepartment.class);
    }
}

package com.rgoswami3414.mydepartment.Service;

import com.rgoswami3414.mydepartment.Dtos.Dtos.*;
import com.rgoswami3414.mydepartment.Exceptions.ResourceNotFoundException;
import com.rgoswami3414.mydepartment.Model.Department;
import com.rgoswami3414.mydepartment.Repository.DepartmentRepo;
import com.rgoswami3414.mydepartment.Repository.EmployeeRepo;
import com.rgoswami3414.mydepartment.Repository.SalaryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

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
    public List<ResponseDepartment> getAllDepartment(int page , int offset){
        Pageable pageable =  PageRequest.of(page,offset);
      Page<Department> departments = departmentRepo.findAll(pageable);
      List<Department> departmentList = departments.getContent();
      return  departmentList.stream().map(d->mapToDep(d)).toList();
    }
    public ResponseDepartment getDepartment(int id) {
        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Department not found with id: " + id
                ));
        return modelMapper.map(department,ResponseDepartment.class);
    }
    public ResponseDepartment updateDepartment(UpdateDepartment requestDepartment){
         Department department = departmentRepo.findById(requestDepartment.getId()).orElseThrow(
                 ()-> new ResourceNotFoundException("department with this id does not exist")
         );
         Department updateDepartment = modelMapper.map(requestDepartment,Department.class);
         department = departmentRepo.save(updateDepartment);
         return modelMapper.map(department,ResponseDepartment.class);
    }
    private ResponseDepartment mapToDep(Department d){
       return ResponseDepartment.builder()
                .id(d.getId())
                .departmentName(d.getDepartmentName())
                .specification(d.getSpecification())
                .location(d.getLocation())
                .createdAt(d.getCreatedAt())
                .build();
    }
}

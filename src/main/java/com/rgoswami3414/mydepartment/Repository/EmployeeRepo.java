package com.rgoswami3414.mydepartment.Repository;

import com.rgoswami3414.mydepartment.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}

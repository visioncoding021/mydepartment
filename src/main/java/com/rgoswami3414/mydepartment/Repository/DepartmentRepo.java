package com.rgoswami3414.mydepartment.Repository;

import com.rgoswami3414.mydepartment.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}

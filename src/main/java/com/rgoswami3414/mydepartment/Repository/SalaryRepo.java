package com.rgoswami3414.mydepartment.Repository;

import com.rgoswami3414.mydepartment.Model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepo extends JpaRepository<Salary,Long> {
}

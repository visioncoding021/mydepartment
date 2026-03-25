package com.rgoswami3414.mydepartment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Department extends JpaRepository<Department,Integer> {
}

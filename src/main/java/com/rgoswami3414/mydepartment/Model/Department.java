package com.rgoswami3414.mydepartment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "department_name",unique = true)
    private String departmentName;
    private String location;
    private String Specification;
    private boolean isActive;
    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Employee> employees;
    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected  void onCreation(){
        createdAt = LocalDateTime.now();
        isActive = true;
    }
    @PreUpdate void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}

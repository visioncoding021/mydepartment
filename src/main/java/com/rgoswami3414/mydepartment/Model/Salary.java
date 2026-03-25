package com.rgoswami3414.mydepartment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private double amount;
    private LocalDateTime effectiveFrom;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreation(){
        createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }

}

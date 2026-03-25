package com.rgoswami3414.mydepartment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee",
        indexes = {
        @Index(name = "emp_id_index",columnList = "id"),
        @Index(name = "emp_name_index",columnList = "firstName,lastName"),
        @Index(name="emp_email_index",columnList = "email"),
        @Index(name = "emp_phoneNo_index",columnList = "phoneNo")

        }
)
public class Employee {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 @Column(name = "first_name")
 private String firstName;
 @Column(name = "last_name")
 private String lastName;
 @Column(unique = true)
 private String email;
 @Column(name = "phone_no",unique = true)
 private String phoneNo;
 private int experience;
 private int age;
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "manager_id")
 private Employee manager;
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "department_id")
 private Department department;
 private boolean isActive;
 @Column(name = "date_of_joining",updatable = false)
 private LocalDateTime dateOfJoining;
 @Column(name = "created_at",updatable = false)
 private LocalDateTime createdAt;
 @Column(name = "updated_at")
 private LocalDateTime updatedAt;
 @PrePersist
    protected void onCreation(){
     createdAt = LocalDateTime.now();
     dateOfJoining = LocalDateTime.now();
     isActive = true;
 }
 @PreUpdate
    protected void onUpdate(){
     updatedAt = LocalDateTime.now();
 }
}

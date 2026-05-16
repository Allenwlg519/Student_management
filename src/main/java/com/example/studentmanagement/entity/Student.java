package com.example.studentmanagement.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Student {
    private Long id;
    private String studentNo;
    private String name;
    private Integer gender;
    private Integer age;
    private String className;
    private String major;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

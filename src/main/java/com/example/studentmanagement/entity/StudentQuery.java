package com.example.studentmanagement.entity;

import lombok.Data;

@Data
public class StudentQuery {
    private String studentNo;
    private String name;
    private Integer gender;
    private String className;
    private String major;
    private Integer pageNum;
    private Integer pageSize;
}

package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.PageResult;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.entity.StudentQuery;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    
    int updateStudent(Student student);
    
    int deleteStudent(Long id);
    
    Student getStudentById(Long id);
    
    List<Student> getAllStudents();
    
    PageResult<Student> getStudentsByPage(StudentQuery query);
}

package com.example.studentmanagement.mapper;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.entity.StudentQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    int insert(Student student);
    
    int update(Student student);
    
    int deleteById(Long id);
    
    Student selectById(Long id);
    
    List<Student> selectAll();
    
    List<Student> selectByQuery(StudentQuery query);
    
    Long countByQuery(StudentQuery query);
    
    Student selectByStudentNo(String studentNo);
}

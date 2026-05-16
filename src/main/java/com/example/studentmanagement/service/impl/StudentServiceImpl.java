package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.entity.PageResult;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.entity.StudentQuery;
import com.example.studentmanagement.mapper.StudentMapper;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int addStudent(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int deleteStudent(Long id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentMapper.selectById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

    @Override
    public PageResult<Student> getStudentsByPage(StudentQuery query) {
        if (query.getPageNum() == null || query.getPageNum() < 0) {
            query.setPageNum(0);
        }
        if (query.getPageSize() == null || query.getPageSize() <= 0) {
            query.setPageSize(10);
        }
        List<Student> list = studentMapper.selectByQuery(query);
        Long total = studentMapper.countByQuery(query);
        return new PageResult<>(list, total, query.getPageNum(), query.getPageSize());
    }
}

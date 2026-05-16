package com.example.studentmanagement.controller;

import com.example.studentmanagement.common.Result;
import com.example.studentmanagement.entity.PageResult;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.entity.StudentQuery;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Result<Integer> addStudent(@RequestBody Student student) {
        int result = studentService.addStudent(student);
        if (result > 0) {
            return Result.success("新增成功", result);
        }
        return Result.error("新增失败");
    }

    @PutMapping("/{id}")
    public Result<Integer> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        int result = studentService.updateStudent(student);
        if (result > 0) {
            return Result.success("更新成功", result);
        }
        return Result.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteStudent(@PathVariable Long id) {
        int result = studentService.deleteStudent(id);
        if (result > 0) {
            return Result.success("删除成功", result);
        }
        return Result.error("删除失败");
    }

    @GetMapping("/{id}")
    public Result<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return Result.success(student);
        }
        return Result.error(404, "学生不存在");
    }

    @GetMapping
    public Result<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return Result.success(students);
    }

    @GetMapping("/page")
    public Result<PageResult<Student>> getStudentsByPage(
            @RequestParam(required = false) String studentNo,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer gender,
            @RequestParam(required = false) String className,
            @RequestParam(required = false) String major,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        
        StudentQuery query = new StudentQuery();
        query.setStudentNo(studentNo);
        query.setName(name);
        query.setGender(gender);
        query.setClassName(className);
        query.setMajor(major);
        query.setPageNum(pageNum);
        query.setPageSize(pageSize);
        
        PageResult<Student> result = studentService.getStudentsByPage(query);
        return Result.success(result);
    }
}

package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.StudentDTO;
import com.example.manageruniversity.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.saveOrUpdate(studentDTO);
    }
    public StudentDTO updateStudent(@PathVariable("studentId") Long studentId,
                                    @RequestBody StudentDTO studentDTO) {
        studentDTO.setId(studentId);
        return studentService.saveOrUpdate(studentDTO);
    }
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.delete(studentId);
    }
    public List<StudentDTO> studentList() {
        return studentService.records();
    }
}

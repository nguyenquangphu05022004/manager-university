package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.StudentDTO;
import com.example.manageruniversity.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class StudentController {
    private final IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/students")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.saveOrUpdate(studentDTO);
    }
    @PutMapping("/students/{studentId}")
    public StudentDTO updateStudent(@PathVariable("studentId") Long studentId,
                                    @RequestBody StudentDTO studentDTO) {
        studentDTO.setId(studentId);
        return studentService.saveOrUpdate(studentDTO);
    }
    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.delete(studentId);
    }
    @GetMapping("/students")
    public List<StudentDTO> studentList() {
        return studentService.records();
    }
}

package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.TeacherDTO;
import com.example.manageruniversity.dto.UserDTO;
import com.example.manageruniversity.service.ITeacherService;
import com.example.manageruniversity.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TeacherController {
    private final ITeacherService teacherService;

    @PostMapping("/teachers")
    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.saveOrUpdate(teacherDTO);
    }
    @GetMapping("/teachers")
    public List<TeacherDTO> teacherList() {
        return teacherService.records();
    }
    @DeleteMapping("/teachers/{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.delete(teacherId);
    }
    @PutMapping("/teachers/{teacherId}")
    public TeacherDTO updateTeacher(@PathVariable("teacherId") Long teacherId,
                                    @RequestBody TeacherDTO teacherDTO) {
        teacherDTO.setId(teacherId);
        return teacherService.saveOrUpdate(teacherDTO);
    }
    @GetMapping("/teachers/{teacherId}")
    public TeacherDTO findById(@PathVariable("teacherId") Long teacherId) {
        return teacherService.findById(teacherId);
    }


}

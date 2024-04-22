package com.example.manageruniversity.dto.auth;

import com.example.manageruniversity.dto.StudentDTO;
import com.example.manageruniversity.dto.TeacherDTO;
import com.example.manageruniversity.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
    private StudentDTO studentDTO;
    private TeacherDTO teacherDTO;
}

package com.example.manageruniversity.dto;

import com.example.manageruniversity.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO extends BaseDTO{
    private String username;
    private Role role;
    private StudentDTO studentDTO;
    private TeacherDTO teacherDTO;
    private AvatarResponse avatarResponse;
}

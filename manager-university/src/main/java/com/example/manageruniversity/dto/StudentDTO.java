package com.example.manageruniversity.dto;

import com.example.manageruniversity.entity.Major;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends PersonDTO {
    private MajorDTO major;
    private CoursesDTO courses;
    private UserDTO user;
}

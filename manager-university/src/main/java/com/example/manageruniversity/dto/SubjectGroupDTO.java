package com.example.manageruniversity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class SubjectGroupDTO extends BaseDTO{
    private String groupName;
    private SubjectDTO subject;
    private TeacherDTO teacher;
    private Integer numberOfStudent;
    private List<TimeDTO> times = new ArrayList<>();
    private List<RegisterDTO> registerDTOS = new ArrayList<>();
    private int numberOfStudentCurrent;
}

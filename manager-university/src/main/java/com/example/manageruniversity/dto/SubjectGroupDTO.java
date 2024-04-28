package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Data
public class SubjectGroupDTO extends BaseDTO{
    private String groupName;
    private SubjectDTO subjectDTO;
    private TeacherDTO teacher;
    private Integer numberOfStudent;
    private List<TimeDTO> times = new ArrayList<>();
    private List<RegisterDTO> registerDTOS = new ArrayList<>();
}

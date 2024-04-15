package com.example.manageruniversity.dto;

import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.entity.Subject;
import com.example.manageruniversity.entity.Teacher;
import com.example.manageruniversity.entity.Time;

import java.util.ArrayList;
import java.util.List;

public class SubjectGroupDTO extends BaseDTO{
    private String groupName;
    private SubjectDTO subjectDTO;
    private Integer numberOfStudent;
    private List<TimeDTO> timeDTOS = new ArrayList<>();
    private List<RegisterDTO> registerDTOS = new ArrayList<>();
}

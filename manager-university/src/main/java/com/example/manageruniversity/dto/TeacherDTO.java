package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TeacherDTO extends PersonDTO{
    private MajorDTO majorDTO;
    private Long userId;
    private List<SubjectGroupDTO> subjectGroupDTOS = new ArrayList<>();
}

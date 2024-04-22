package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Data
public class TeacherDTO extends PersonDTO{
    private MajorDTO majorDTO;
    private List<SubjectDTO> subjectDTOS = new ArrayList<>();
    private Long userId;
}

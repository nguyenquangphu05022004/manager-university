package com.example.manageruniversity.dto;

import com.example.manageruniversity.entity.Season;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegisterDTO extends BaseDTO{
    private StudentDTO studentDTO;
    private SubjectGroupDTO subjectGroup;
    private boolean openTransaction;
    private GradeDTO grade;
    private MajorRegisterDTO majorRegisterDTO;
    private List<RegisterDTO> listRegisterRequest = new ArrayList<>();


}

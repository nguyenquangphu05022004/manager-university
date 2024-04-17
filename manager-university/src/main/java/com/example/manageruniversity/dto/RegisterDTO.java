package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;
@Getter
@Data
public class RegisterDTO extends BaseDTO{
    private StudentDTO studentDTO;
    private SubjectGroupDTO subjectGroupDTO;
    private boolean openTransaction;
}

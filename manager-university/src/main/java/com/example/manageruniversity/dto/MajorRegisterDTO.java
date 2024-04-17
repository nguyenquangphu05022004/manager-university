package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Data
public class MajorRegisterDTO extends BaseDTO {
    private List<SubjectDTO> subjectDTOS = new ArrayList<>();
    private MajorDTO majorDTO;
    private SeasonDTO seasonDTO;
}

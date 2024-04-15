package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Data
public class SubjectDTO extends BaseDTO{
    private String subjectName;
    private String subjectCode;
    private Integer credit;
    private TuitionDTO tuitionDTO;
    private List<SubjectGroupDTO> subjectGroupDTOS = new ArrayList<>();
    private Set<TestScheduleDTO> testScheduleDTOS = new HashSet<>();

    public Integer priceOfSubject() {
        return tuitionDTO.getMoneyPerCredit() * credit;
    }
}

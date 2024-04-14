package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Data
public class SchoolYearDTO extends BaseDTO{
    private String name;
    private List<SeasonDTO> seasonDTOS = new ArrayList<>();
}

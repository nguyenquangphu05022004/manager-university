package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class SeasonDTO extends BaseDTO{

    private SemesterDTO semester;

    private SchoolYearDTO schoolYear;

    private CoursesDTO courses;
}

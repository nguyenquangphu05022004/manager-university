package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Data
public class SeasonDTO extends BaseDTO{
    private SemesterDTO semester;
    private SchoolYearDTO schoolYear;
    private CoursesDTO courses;
    private boolean disabled;
    private List<MajorRegisterDTO> majorRegisterDTOS = new ArrayList<>();


    public String getNameSeason() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Năm học ");
        stringBuilder.append(schoolYear.getName());
        stringBuilder.append(" ");
        stringBuilder.append(semester.getSemesterName());
        stringBuilder.append(" của khóa ");
        stringBuilder.append(courses.getName());
        stringBuilder.append("_");
        stringBuilder.append(courses.getCode());
        return stringBuilder.toString();
    }
}

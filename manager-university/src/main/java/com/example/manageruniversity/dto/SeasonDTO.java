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
    private List<RegisterDTO> registers = new ArrayList<>();
    private TuitionDTO tuition;
    private boolean disabled;


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
    public int getTuitionOfSeason() {
        int t = 0;
        for(int i = 0; i < registers.size(); i++) {
            RegisterDTO r = registers.get(i);
            SubjectDTO s = r.getSubjectGroup().getSubject();
            t += tuition.getMoneyPerCredit() * s.getCredit();
        }
        return t;
    }
    public int getTotalCredit() {
        int t = 0;
        for(int i = 0; i < registers.size(); i++) {
            RegisterDTO r = registers.get(i);
            SubjectDTO s = r.getSubjectGroup().getSubject();
            t +=s.getCredit();
        }
        return t;
    }

    public double getSeasonGradeAverage() {
        double a = 0;
        for(int i = 0; i < registers.size(); i++) {
            RegisterDTO r = registers.get(i);
            if(r.getGradeDTO() != null) {
                a += r.getGradeDTO().getSubjectAverage();
            }
        }
        return a/(registers.size());
    }

}

package com.example.manageruniversity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradeDTO {
    private RegisterDTO register;
    private double attend;
    private double midtermTest;
    private double finalTest;
    private double practiceTest;
    private ComponentGradeDTO componentGrade;

    public double getSubjectAverage() {
        double a = attend * componentGrade.getAttend() * 0.1 +
                midtermTest * componentGrade.getMidtermTest() * 0.1 +
                finalTest * componentGrade.getFinalTest() * 0.1 +
                practiceTest * componentGrade.getPracticeTest() * 0.1;
        return a;
    }
}

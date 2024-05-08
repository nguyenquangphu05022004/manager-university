package com.example.manageruniversity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeDTO {
    private float attend;
    private float midtermTest;
    private float finalTest;
    private float practiceTest;
    private ComponentGradeDTO componentGrade;

    public float getSubjectAverage() {
        if(componentGrade == null) return 0;
        float a =  (attend * componentGrade.getAttend() * 0.01f +
                        midtermTest * componentGrade.getMidtermTest() * 0.01f +
                        finalTest * componentGrade.getFinalTest() * 0.01f +
                        practiceTest * componentGrade.getPracticeTest() * 0.01f);
        return a;
    }

}

package com.example.manageruniversity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComponentGradeDTO extends BaseDTO{
    private int attend;
    private int midtermTest;
    private int finalTest;
    private int practiceTest;

    public String getDetails() {
        return attend + " - " + practiceTest + " - " + midtermTest + " - " + finalTest;
    }
}

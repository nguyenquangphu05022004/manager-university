package com.example.manageruniversity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class SubjectDTO extends BaseDTO{
    private String subjectName;
    private String subjectCode;
    private Integer credit;
    private List<SubjectGroupDTO> subjectGroupDTOS = new ArrayList<>();

    public String getSubName() {
        if(subjectName == null) return null;
        String s = subjectName.toUpperCase();
        var words = s.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for(var n : words) {
            builder.append(n.charAt(0));
        }
        return builder.toString();
    }
}

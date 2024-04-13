package com.example.manageruniversity.dto;

import com.example.manageruniversity.entity.Major;
import com.example.manageruniversity.entity.TestSchedule;
import com.example.manageruniversity.entity.Tuition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubjectDTO {
    private String subjectName;
    private String subjectCode;
    private Integer credit;
    private Tuition tuition;
    private List<SubjectGroupDTO> subjectGroups = new ArrayList<>();
    private Major major;
    private Set<TestSchedule> testSchedules = new HashSet<>();
}

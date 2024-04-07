package com.example.manageruniversity.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject extends Base{
    private String subjectName;
    private String subjectCode;
    private Integer credit;
    @OneToOne
    @JoinColumn(name = "tuition_id")
    private Tuition tuition;
    @OneToMany(mappedBy = "subject")
    private List<SubjectGroup> subjectGroups = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "major_Id")
    private Major major;
}

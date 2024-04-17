package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subjects")
@Getter
@Data
public class Subject extends Base{
    private String subjectName;
    private String subjectCode;
    private Integer credit;
    @OneToOne
    @JoinColumn(name = "tuition_id")
    private Tuition tuition;
    @OneToMany(mappedBy = "subject")
    private List<SubjectGroup> subjectGroups = new ArrayList<>();
    @ManyToMany(mappedBy = "subjects")
    private  List<MajorRegister> majorRegisters = new ArrayList<>();
    @ManyToMany(mappedBy = "subjects")
    private Set<TestSchedule> testSchedules = new HashSet<>();
    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers = new ArrayList<>();
}

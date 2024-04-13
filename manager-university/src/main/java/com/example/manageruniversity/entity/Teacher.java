package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Data
public class Teacher extends Person{
    @ManyToMany
    @JoinTable(name = "teacher_subject_groups")
    private List<SubjectGroup> subjectGroups = new ArrayList<>();
}

package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "registers")
@Getter
@Deprecated
public class Register extends Base{
    @ManyToOne
    @JoinColumn(name = "student_dd")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subject_group_id")
    private SubjectGroup subjectGroup;
    @OneToOne(mappedBy = "register")
    private Grade grade;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    private boolean status;
}

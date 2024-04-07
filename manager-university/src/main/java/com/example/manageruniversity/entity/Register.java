package com.example.manageruniversity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "registers")
public class Register extends Base{
    @ManyToOne
    @JoinColumn(name = "student_dd")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subject_group_id")
    private SubjectGroup subjectGroup;
    @OneToOne(mappedBy = "register")
    private Grade grade;
    private boolean status;
}

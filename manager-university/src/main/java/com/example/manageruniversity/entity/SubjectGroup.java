package com.example.manageruniversity.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject_group")
public class SubjectGroup extends Base {
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    private Integer numberOfStudent;
    @OneToMany(mappedBy = "subjectGroup")
    private List<Time> times = new ArrayList<>();
    @OneToMany(mappedBy = "subjectGroup")
    private List<Register> registers = new ArrayList<>();
}

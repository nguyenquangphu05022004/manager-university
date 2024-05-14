package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject_group")
@Getter
@Setter
public class SubjectGroup extends Base {
    private String groupName;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    private Integer numberOfStudent;

    @OneToMany(mappedBy = "subjectGroup")
    private List<Time> times = new ArrayList<>();

    @OneToMany(mappedBy = "subjectGroup")
    private List<Register> registers = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private int numberOfStudentCurrent;

    @Override
    public boolean equals(Object o) {
        if(o instanceof SubjectGroup) {
            SubjectGroup s = (SubjectGroup) o;
            if(s.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }
}

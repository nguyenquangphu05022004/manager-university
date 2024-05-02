package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subjects")
@Getter
@Setter
public class Subject extends Base{
    private String subjectName;
    private String subjectCode;
    private Integer credit;
    @OneToMany(mappedBy = "subject")
    private List<SubjectGroup> subjectGroups = new ArrayList<>();
    @ManyToMany(mappedBy = "subjects")
    private  List<MajorRegister> majorRegisters = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if(o instanceof Subject) {
            Subject s = (Subject) o;
            if(this.getId() == s.getId()) {
                return true;
            }
        }
        return false;
    }
}

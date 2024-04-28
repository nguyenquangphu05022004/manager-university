package com.example.manageruniversity.entity;

import com.example.manageruniversity.entity.auth.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher extends Person{

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    @OneToMany(mappedBy = "teacher")
    private List<SubjectGroup> subjectGroups = new ArrayList<>();
}

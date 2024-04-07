package com.example.manageruniversity.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "majors")
public class Major extends Base{
    private String name;
    private String sub;
    @OneToMany(mappedBy = "major")
    private List<Subject> subjects = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
}

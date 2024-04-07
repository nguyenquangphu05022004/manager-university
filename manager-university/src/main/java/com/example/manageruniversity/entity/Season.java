package com.example.manageruniversity.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seasons")
public class Season extends Base{
    @ManyToOne
    @JoinTable(name = "semester_id")
    private Semester semester;
    @ManyToOne
    @JoinTable(name = "school_year_Id")
    private SchoolYear schoolYear;
    @ManyToMany
    @JoinTable(name = "season_student", joinColumns = @JoinColumn(name = "season_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses courses;
}

package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seasons")
@Getter
@Data
public class Season extends Base{
    @ManyToOne
    @JoinColumn(name = "season_semester")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "school_year_Id")
    private SchoolYear schoolYear;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses courses;

    @OneToOne(mappedBy = "season")
    private Tuition tuition;

    @OneToMany(mappedBy = "season")
    private List<TestSchedule> testSchedules = new ArrayList<>();

    private boolean disabled;

}

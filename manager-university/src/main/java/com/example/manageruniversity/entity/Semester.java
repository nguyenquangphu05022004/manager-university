package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "semesters")
public class Semester extends Base{
    @OneToMany(mappedBy = "semester")
    private List<Major> majors = new ArrayList<>();
    @OneToMany(mappedBy = "semester")
    private List<Season> seasons = new ArrayList<>();
}

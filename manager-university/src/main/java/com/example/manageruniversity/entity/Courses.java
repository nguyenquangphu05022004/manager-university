package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Courses extends Base{
    @OneToMany(mappedBy = "courses")
    private List<Season> seasons = new ArrayList<>();

}

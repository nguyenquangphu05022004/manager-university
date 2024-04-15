package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Data
public class Courses extends Base{
    private String name;
    private String code;
    @OneToMany(mappedBy = "courses")
    private List<Season> seasons = new ArrayList<>();
    @OneToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}

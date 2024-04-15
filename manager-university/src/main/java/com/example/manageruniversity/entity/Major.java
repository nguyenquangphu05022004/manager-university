package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "majors")
@Getter
@Data
public class Major extends Base{
    private String name;
    private String sub;
    @ManyToMany
    @JoinTable(name = "major_subject", joinColumns = @JoinColumn(name = "major_id"),
    inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    @OneToMany(mappedBy = "major")
    private List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "major")
    private List<Teacher> teachers = new ArrayList<>();
}

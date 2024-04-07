package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends Person{
    @ManyToMany(mappedBy = "students")
    private List<Season> seasons = new ArrayList<>();
    @OneToMany(mappedBy = "student")
    private List<Register> registers = new ArrayList<>();
}

package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Data
public class Student extends Person{
    @OneToMany(mappedBy = "student")
    private List<Register> registers = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
}

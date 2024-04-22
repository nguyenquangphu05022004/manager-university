package com.example.manageruniversity.entity;

import com.example.manageruniversity.entity.auth.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

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
    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses courses;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user = new User();

    @OneToMany(mappedBy = "student")
    private List<Transaction> transactions = new ArrayList<>();
}

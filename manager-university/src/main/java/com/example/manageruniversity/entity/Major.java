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

    @OneToMany(mappedBy = "major")
    private List<MajorRegister> majorRegisters = new ArrayList<>();


    @OneToMany(mappedBy = "major")
    private List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "major")
    private List<Teacher> teachers = new ArrayList<>();
}

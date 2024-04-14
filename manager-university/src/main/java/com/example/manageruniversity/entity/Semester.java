package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "semesters")
@Data
@Setter
public class Semester extends Base{
    private String semesterName;
    @OneToMany(mappedBy = "semester")
    private List<Season> seasons = new ArrayList<>();
}

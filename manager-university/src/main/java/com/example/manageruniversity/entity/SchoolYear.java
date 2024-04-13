package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "school_years")
@Getter
@Data
public class SchoolYear extends Base{
    private String name;
    @OneToMany(mappedBy = "schoolYear")
    private List<Season> seasons = new ArrayList<>();
}

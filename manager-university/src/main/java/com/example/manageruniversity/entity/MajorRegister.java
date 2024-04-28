package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "majorRegisters")
@Getter
@Data
public class MajorRegister extends Base{

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToMany
    @JoinTable(name = "majorRegister_Subject",joinColumns = @JoinColumn(name = "majorRegister_id"),
    inverseJoinColumns = @JoinColumn(name = "subjectId"))
    private List<Subject> subjects = new ArrayList<>();

}

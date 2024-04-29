package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "test_schedules")
@Getter
@Data
public class TestSchedule extends Base{
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "testSchedule")
    private List<StudentsTestRoom> studentsTestRooms = new ArrayList<>();
}

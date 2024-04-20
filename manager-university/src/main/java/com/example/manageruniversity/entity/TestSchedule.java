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
    @JoinColumn(name = "room_class_id")
    private RoomClass roomClass;
    private Integer numberOfStudent;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToMany
    @JoinTable(name = "test_schedule_subjects", joinColumns = @JoinColumn(name = "test_schedule_id"),
    inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects = new HashSet<>();

}

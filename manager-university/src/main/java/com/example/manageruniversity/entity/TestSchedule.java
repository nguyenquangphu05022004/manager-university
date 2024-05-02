package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test_schedules")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestSchedule extends Base{
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    private Integer roomNumber;
    @ManyToOne
    @JoinColumn(name = "room_class_id")
    private RoomClass roomClass;
    private Integer numberOfStudent;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalTime endTime;
    @Enumerated(EnumType.STRING)
    private TestType testType;
    @ManyToMany
    @JoinTable(name = "testSchedule_student",
            joinColumns = @JoinColumn(name = "testSchedule_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}

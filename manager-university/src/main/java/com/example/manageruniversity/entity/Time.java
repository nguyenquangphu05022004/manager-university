package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "times")
public class Time extends Base{
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "subject_group_id")
    private SubjectGroup subjectGroup;
    @ManyToOne
    @JoinColumn(name = "room_class_id")
    private RoomClass roomClass;
}

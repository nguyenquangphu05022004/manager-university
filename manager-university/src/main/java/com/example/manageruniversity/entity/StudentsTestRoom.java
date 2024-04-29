package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students_test_rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentsTestRoom extends Base{
    @ManyToOne
    @JoinColumn(name = "room_class_id")
    private RoomClass roomClass;
    private Integer numberOfStudent;
    private LocalDateTime startTest;
    private LocalDateTime endTest;
    @Enumerated(EnumType.STRING)
    private TestType testType;
    @ManyToMany
    @JoinTable(name = "test_room_student", joinColumns = @JoinColumn(name = "students_test_room_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_schedule_id")
    private TestSchedule testSchedule;
}

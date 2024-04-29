package com.example.manageruniversity.dto;

import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.entity.StudentsTestRoom;
import com.example.manageruniversity.entity.Subject;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class TestScheduleDTO {

    private SeasonDTO season;
    private SubjectDTO subjectDTO;
    private List<StudentsTestRoom> studentsTestRooms = new ArrayList<>();
}

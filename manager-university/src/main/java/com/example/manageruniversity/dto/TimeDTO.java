package com.example.manageruniversity.dto;

import com.example.manageruniversity.entity.RoomClass;
import com.example.manageruniversity.entity.SubjectGroup;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Data
@ToString
public class TimeDTO extends BaseDTO{
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private RoomClassDTO roomClassDTO;
    private SubjectGroupDTO subjectGroupDTO;
}

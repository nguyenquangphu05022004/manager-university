package com.example.manageruniversity.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TimeDTO extends BaseDTO{
    private Integer dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private SubjectGroupDTO subjectGroupDTO;
    private RoomClassDTO roomClassDTO;
}

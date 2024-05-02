package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.TestScheduleDTO;

import java.util.List;

public interface ITestScheduleService {
    void saveOrUpdate(TestScheduleDTO testScheduleDTO);
    List<TestScheduleDTO> getListBySeasonIdAndStudentId(Long seasonId, Long studentId);
}

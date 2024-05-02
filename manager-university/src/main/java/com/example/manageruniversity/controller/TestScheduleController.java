package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.TestScheduleDTO;
import com.example.manageruniversity.service.ITestScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TestScheduleController {
    private final ITestScheduleService testScheduleService;

    @PostMapping("/testSchedules")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTestSchedule(@RequestBody TestScheduleDTO testScheduleDTO) {
        testScheduleService.saveOrUpdate(testScheduleDTO);
    }

    @GetMapping("/testSchedules")
    public List<TestScheduleDTO> getListBySeasonAndStudent(@RequestParam("seasonId") Long seasonId,
                                                           @RequestParam("studentId") Long studentId) {
        return testScheduleService.getListBySeasonIdAndStudentId(seasonId, studentId);
    }
}

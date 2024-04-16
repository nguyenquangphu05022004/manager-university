package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.SemesterDTO;
import com.example.manageruniversity.service.ISemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SemesterController {
    private final ISemesterService semesterService;

    @Autowired
    public SemesterController(ISemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @PostMapping("/api/semesters")
    public SemesterDTO createSemester(@RequestBody SemesterDTO semesterDTO) {
        return semesterService.saveOrUpdate(semesterDTO);
    }
    @PutMapping("/api/semesters/{semesterId}")
    public SemesterDTO updateSemester(@PathVariable("semesterId") Long semesterId,
                                      @RequestBody SemesterDTO semesterDTO) {
        semesterDTO.setId(semesterId);
        return semesterService.saveOrUpdate(semesterDTO);
    }
    @GetMapping("/api/semesters")
    public List<SemesterDTO> semesterList() {
        return semesterService.records();
    }
    @DeleteMapping("/api/semesters/{semesterId}")
    public void deleteSemester(@PathVariable("semesterId") Long semesterId) {
        semesterService.delete(semesterId);
    }
}

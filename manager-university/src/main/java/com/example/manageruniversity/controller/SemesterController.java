package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.SemesterDTO;
import com.example.manageruniversity.service.ISemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class SemesterController {
    private final ISemesterService semesterService;

    @Autowired
    public SemesterController(ISemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @PostMapping("/semesters")
    public SemesterDTO createSemester(@RequestBody SemesterDTO semesterDTO) {
        return semesterService.saveOrUpdate(semesterDTO);
    }
    @PutMapping("/semesters/{semesterId}")
    public SemesterDTO updateSemester(@PathVariable("semesterId") Long semesterId,
                                      @RequestBody SemesterDTO semesterDTO) {
        semesterDTO.setId(semesterId);
        return semesterService.saveOrUpdate(semesterDTO);
    }
    @GetMapping("/semesters")
    public List<SemesterDTO> semesterList() {
        return semesterService.records();
    }
    @DeleteMapping("/semesters/{semesterId}")
    public void deleteSemester(@PathVariable("semesterId") Long semesterId) {
        semesterService.delete(semesterId);
    }
}

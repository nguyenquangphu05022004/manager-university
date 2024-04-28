package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.SchoolYearDTO;
import com.example.manageruniversity.service.ISchoolYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class SchoolYearController {

    private final ISchoolYearService schoolYearService;

    @Autowired
    public SchoolYearController(ISchoolYearService schoolYearService) {
        this.schoolYearService = schoolYearService;
    }

    @PostMapping("/schoolYears")
    public SchoolYearDTO createSchoolYear(@RequestBody SchoolYearDTO schoolYearDTO) {
        return schoolYearService.saveOrUpdate(schoolYearDTO);
    }
    @PutMapping("/schoolYears/{schoolYearId}")
    public SchoolYearDTO updateSchoolYear(@PathVariable("schoolYearId") Long schoolYearId,
                                          @RequestBody SchoolYearDTO schoolYearDTO) {
        schoolYearDTO.setId(schoolYearId);
        return schoolYearService.saveOrUpdate(schoolYearDTO);
    }
    @DeleteMapping("/api/schoolYears/{schoolYearId}")
    public void deleteSchoolYear(@PathVariable("schoolYearId") Long schoolYearId) {
        schoolYearService.delete(schoolYearId);
    }
    @GetMapping("/schoolYears")
    public List<SchoolYearDTO> schoolYearList() {
        return schoolYearService.records();
    }
}

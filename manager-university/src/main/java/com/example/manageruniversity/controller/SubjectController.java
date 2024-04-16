package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    private  final ISubjectService subjectService;

    @Autowired
    public SubjectController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/api/subjects")
    public SubjectDTO createSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.saveOrUpdate(subjectDTO);
    }
    @PutMapping("/api/subjects/{subjectId}")
    public SubjectDTO updateSubject(@PathVariable("subjectId") Long subjectId,
                                    @RequestBody SubjectDTO subjectDTO) {
        subjectDTO.setId(subjectId);
        return subjectService.saveOrUpdate(subjectDTO);
    }
    @DeleteMapping("/api/subjects/{subjectId}")
    public void deleteSubject(@PathVariable("subjectId") Long subjectId) {
        subjectService.delete(subjectId);
    }

    @GetMapping("/api/subjects")
    public List<SubjectDTO> subjectList() {
        return subjectService.records();
    }
}

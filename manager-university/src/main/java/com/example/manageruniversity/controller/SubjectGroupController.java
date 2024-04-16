package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.mapper.SubjectGroupMapper;
import com.example.manageruniversity.service.ISubjectGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectGroupController {
    private final ISubjectGroupService subjectGroupService;

    @Autowired
    public SubjectGroupController(ISubjectGroupService subjectGroupService) {
        this.subjectGroupService = subjectGroupService;
    }

    @GetMapping("/api/subjectGroups")
    public List<SubjectGroupDTO> subjectGroupList() {
        return subjectGroupService.records();
    }

    @PostMapping("/api/subjectGroups")
    public SubjectGroupDTO createSubjectGroup(@RequestBody SubjectGroupDTO subjectGroupDTO) {
        return subjectGroupService.saveOrUpdate(subjectGroupDTO);
    }

    @DeleteMapping("/api/subjectGroups/{subjectGroupId}")
    public void deleteSubjectGroup(@PathVariable("subjectGroupId") Long subjectGroupId) {
        subjectGroupService.delete(subjectGroupId);
    }
    @PutMapping("/api/subjectGroups/{subjectGroupId}")
    public SubjectGroupDTO updateSubjectGroup(@PathVariable("subjectGroupId") Long subjectGroupId,
                                              @RequestBody SubjectGroupDTO subjectGroupDTO) {
        subjectGroupDTO.setId(subjectGroupId);
        return subjectGroupService.saveOrUpdate(subjectGroupDTO);
    }
}

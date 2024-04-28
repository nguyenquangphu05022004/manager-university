package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.mapper.SubjectGroupMapper;
import com.example.manageruniversity.service.ISubjectGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class SubjectGroupController {
    private final ISubjectGroupService subjectGroupService;

    @Autowired
    public SubjectGroupController(ISubjectGroupService subjectGroupService) {
        this.subjectGroupService = subjectGroupService;
    }

    @GetMapping("/subjectGroups")
    public List<SubjectGroupDTO> subjectGroupList() {
        return subjectGroupService.records();
    }

    @PostMapping("/subjectGroups")
    public SubjectGroupDTO createSubjectGroup(@RequestBody SubjectGroupDTO subjectGroupDTO) {
        return subjectGroupService.saveOrUpdate(subjectGroupDTO);
    }

    @DeleteMapping("/subjectGroups/{subjectGroupId}")
    public void deleteSubjectGroup(@PathVariable("subjectGroupId") Long subjectGroupId) {
        subjectGroupService.delete(subjectGroupId);
    }
    @PutMapping("/subjectGroups/{subjectGroupId}")
    public SubjectGroupDTO updateSubjectGroup(@PathVariable("subjectGroupId") Long subjectGroupId,
                                              @RequestBody SubjectGroupDTO subjectGroupDTO) {
        subjectGroupDTO.setId(subjectGroupId);
        return subjectGroupService.saveOrUpdate(subjectGroupDTO);
    }
    @GetMapping("/subjectGroups/subject/{subjectId}")
    public List<SubjectGroupDTO> subjectGroupList(@PathVariable("subjectId") Long subjectId) {
        return subjectGroupService.findAllBySubjectId(subjectId);
    }
}

package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;

import java.util.List;

public interface ISubjectGroupService extends IGenericService<SubjectGroupDTO> {
    List<SubjectGroupDTO> findAllBySubjectId(Long subjectId);
}

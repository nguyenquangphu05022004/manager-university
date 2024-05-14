package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.StudentDTO;

import java.util.List;

public interface IStudentService extends IGenericService<StudentDTO> {
    List<StudentDTO> getListStudentBySubjectGroupId(Long subjectGroupId);
}

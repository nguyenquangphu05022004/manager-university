package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.TeacherDTO;

public interface ITeacherService extends IGenericService<TeacherDTO> {
    TeacherDTO findById(Long teacherId);
}

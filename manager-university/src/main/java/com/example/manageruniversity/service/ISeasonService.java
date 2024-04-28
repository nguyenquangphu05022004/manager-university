package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.SeasonDTO;

import java.util.List;

public interface ISeasonService extends IGenericService<SeasonDTO> {
    List<SeasonDTO> findAllByStudentId(Long studentId);
}

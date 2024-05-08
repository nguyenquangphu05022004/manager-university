package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.ComponentGradeDTO;
import com.example.manageruniversity.dto.GradeDTO;

import java.util.List;

public interface IGradeService  {
    void saveOrUpdate(GradeDTO gradeDTO, String subjectCode, String studentCode);

    List<ComponentGradeDTO> getListGradeComponent();
    void initGradeByMajorRegisterId(Long seasonId);
}

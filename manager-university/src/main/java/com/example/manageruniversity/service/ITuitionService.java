package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.TuitionDTO;
import com.example.manageruniversity.entity.Tuition;

import java.util.List;

public interface ITuitionService   {
    void initTuition(TuitionDTO tuitionDTO);
    List<TuitionDTO> listTuition();
}

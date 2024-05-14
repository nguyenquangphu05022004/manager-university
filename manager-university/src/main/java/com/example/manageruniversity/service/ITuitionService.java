package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.TuitionDTO;

import java.util.List;

public interface ITuitionService   {
    void initTuition(TuitionDTO tuitionDTO);
    List<TuitionDTO> listTuition();
}

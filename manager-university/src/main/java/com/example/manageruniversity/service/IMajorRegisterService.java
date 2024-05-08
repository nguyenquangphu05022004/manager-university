package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.MajorRegisterDTO;

import java.util.List;

public interface IMajorRegisterService extends IGenericService<MajorRegisterDTO> {
    /**
     * Season disabled -> after day register subject expired disabled: true
     * else disabled: false
     */
    MajorRegisterDTO findByMajorIdAndSeasonDisabled(Long majorId, boolean disabled); //isBlock default false

    List<MajorRegisterDTO> findAllByStudentId(Long studentId);

    MajorRegisterDTO findByStudentIdAndSeasonNotDisabledAndOpenRegister(Long studentId, boolean openRegister);
}

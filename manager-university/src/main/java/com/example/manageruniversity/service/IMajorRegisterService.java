package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.dto.MajorRegisterDTO;

public interface IMajorRegisterService extends IGenericService<MajorRegisterDTO> {
    /**
     * Season disabled -> after day register subject expired disabled: true
     * else disabled: false
     */
    MajorRegisterDTO findByMajorIdAndSeasonDisabled(Long majorId, boolean disabled); //isBlock default false

}

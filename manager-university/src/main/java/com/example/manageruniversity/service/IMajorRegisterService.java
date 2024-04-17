package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.dto.MajorRegisterDTO;

public interface IMajorRegisterService extends IGenericService<MajorRegisterDTO> {
    MajorRegisterDTO findByMajorIdAndIsBlock(Long majorId); //isBlock default false

}

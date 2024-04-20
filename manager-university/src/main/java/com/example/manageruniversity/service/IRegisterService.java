package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.RegisterDTO;

import java.util.List;

public interface IRegisterService extends IGenericService<RegisterDTO> {
    List<RegisterDTO> recordsByStudentId(Long studentId);

    void transaction(Long registerId, boolean transaction);

    List<RegisterDTO> recordsByTransactionStatus(boolean transaction);
}

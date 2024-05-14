package com.example.manageruniversity.service;

public interface ITransactionService  {
    void save(Long targetRegisterId, Long studentId);
    void confirmTransaction(Long targetRegisterId, Long requestRegisterId);

    void deleteByRegisterIdAndStudentId(Long targetRegister, Long studentRequestId);
}

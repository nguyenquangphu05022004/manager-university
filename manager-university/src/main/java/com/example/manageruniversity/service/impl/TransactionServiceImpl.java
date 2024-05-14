package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.entity.Student;
import com.example.manageruniversity.entity.Transaction;
import com.example.manageruniversity.exception.NotCreateTransactionException;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.repository.RegisterRepository;
import com.example.manageruniversity.repository.StudentRepository;
import com.example.manageruniversity.repository.TransactionRepository;
import com.example.manageruniversity.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements ITransactionService {

    private final TransactionRepository transactionRepository;
    private final StudentRepository studentRepository;
    private final RegisterRepository registerRepository;

    @Override
    public void save(Long targetRegisterId, Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundIdException("Student", "Id",
                        String.valueOf(studentId)));

        Register targetRegister = findRegisterById(targetRegisterId);

        //search subject that student registered like subject of targetRegister
        for (Register registerOfStudent : student.getRegisters()) {
            if (!registerOfStudent.getSubjectGroup()
                    .equals(targetRegister.getSubjectGroup())
                    &&
                    registerOfStudent.getSubjectGroup().getSubject()
                            .equals(targetRegister.getSubjectGroup().getSubject())
            ) {
                transactionRepository.save(new Transaction(targetRegister, student));
                return;
            }
        }
        StringBuilder message = new StringBuilder();
        message.append("Not Create Transaction for targetRegisterId: ");
        message.append(targetRegisterId);
        message.append(" And studentId: ");
        message.append(studentId);
        message.append(". Because You was exists subject group or you didn't register subject");
        throw new NotCreateTransactionException(message.toString());
    }

    @Override
    @Transactional
    public void confirmTransaction(Long targetRegisterId, Long requestRegisterId) {
        Register targetRegister = findRegisterById(targetRegisterId);
        Register requestRegister = findRegisterById(requestRegisterId);

        Student targetStudent = targetRegister.getStudent();
        //update targetRegister for requestStudent and opposite
        targetRegister.setStudent(requestRegister.getStudent());
        targetRegister.setOpenTransaction(false);
        //
        requestRegister.setStudent(targetStudent);
        requestRegister.setOpenTransaction(false);
        //save it:
        registerRepository.save(targetRegister);
        registerRepository.save(requestRegister);
        //after update register we are needing clear all transaction of two register
        //delete request of all student
        transactionRepository.deleteAllByTargetRegisterId(requestRegisterId);
        transactionRepository.deleteAllByTargetRegisterId(targetRegisterId);
        //delete request of current student to all different student
        transactionRepository.deleteAllRequest(requestRegister.getStudent().getId(),
                requestRegister.getSubjectGroup().getSubject().getId());
        transactionRepository.deleteAllRequest(targetRegister.getStudent().getId(),
                targetRegister.getSubjectGroup().getSubject().getId());
    }

    @Override
    @Transactional
    public void deleteByRegisterIdAndStudentId(Long targetRegister, Long studentRequestId) {
        transactionRepository.deleteByTargetRegisterIdAndStudentId(targetRegister, studentRequestId);
    }

    private Register findRegisterById(Long registerId) {
        return registerRepository.findById(registerId)
                .orElseThrow(() -> new NotFoundIdException("Register", "ID",
                        String.valueOf(registerId)));
    }

}

package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.entity.SubjectGroup;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.RegisterMapper;
import com.example.manageruniversity.repository.RegisterRepository;
import com.example.manageruniversity.repository.SubjectGroupRepository;
import com.example.manageruniversity.repository.TransactionRepository;
import com.example.manageruniversity.service.IRegisterService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements IRegisterService {

    private final RegisterRepository registerRepository;
    private final TransactionRepository transactionRepository;
    private final SubjectGroupRepository subjectGroupRepository;

    @Override
    @Transactional
    public RegisterDTO saveOrUpdate(RegisterDTO registerDTO) {
        Register register = RegisterMapper.mapper.registerDTOToEntity(registerDTO);
        SubjectGroup subjectGroup = subjectGroupRepository.findById(register.getSubjectGroup().getId())
                .orElseThrow(() -> new NotFoundIdException("SubjectGroup", "Id", ""));
        if (subjectGroup.getNumberOfStudent() >= subjectGroup.getNumberOfStudentCurrent()) {
            subjectGroup.setNumberOfStudentCurrent(subjectGroup.getNumberOfStudentCurrent() + 1);
            register.setSubjectGroup(subjectGroup);
            registerRepository.save(register);
            return registerDTO;
        }
        throw new RuntimeException("student quantity in class was full");
    }

    @Override
    public List<RegisterDTO> records() {
        List<Register> registers = registerRepository.findAll();
        return convertList(registers);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Register register = registerRepository.findById(id)
                .orElseThrow(() -> new NotFoundIdException("Register", "Id", id.toString()));
        SubjectGroup subjectGroup = register.getSubjectGroup();
        subjectGroup.setNumberOfStudentCurrent(subjectGroup.getNumberOfStudentCurrent() - 1 > 0 ? subjectGroup.getNumberOfStudentCurrent() - 1 : 0);
        subjectGroupRepository.save(subjectGroup);
        transactionRepository.deleteByStudentRequestIdAndTargetSubjectId(register.getStudent().getId(), register.getSubjectGroup().getSubject().getId());
        registerRepository.delete(register);
    }

    @Override
    public void transaction(Long registerId, boolean transaction) {
        Register register = registerRepository.findById(registerId)
                .orElseThrow(() -> new NotFoundIdException("Register", "Id", registerId.toString()));
        register.setOpenTransaction(transaction);
        registerRepository.save(register);
    }

    @Override
    public List<RegisterDTO> recordsByTransactionStatus(boolean transaction) {
        List<Register> registers = registerRepository.findAllByOpenTransaction(transaction);
        return convertList(registers);
    }

    @Override
    public List<RegisterDTO> getRegisterByStudentIdAndSeasonDisabled(Long studentId,
                                                                     boolean disabled,
                                                                     HttpServletResponse response) {
        List<Register> registers = registerRepository.findAllByStudentIdAndMajorRegisterSeasonDisabled(studentId, disabled);
        return convertList(registers);
    }

    @Override
    public List<RegisterDTO> findAllRegisterOpenedBySubjectIdAndNotOfStudentId(Long subjectId, Long studentId) {
        List<Register> registers = registerRepository.findAllRegisterOpenedBySubjectIdAndNotOfStudentId(subjectId, studentId);
        return convertList(registers);
    }

    private List<RegisterDTO> convertList(List<Register> registers) {
        List<RegisterDTO> registerList = registers.stream()
                .map(register -> {
                    RegisterDTO registerDTO = RegisterMapper.mapper.registerToDTO(register);
                    List<RegisterDTO> list = new ArrayList<>();
                    for (Register r : register.getRegisterListRequestFromStudent()) {
                        r.setTransactions(new ArrayList<>());
                        list.add(RegisterMapper.mapper.registerToDTO(r));
                    }
                    registerDTO.setListRegisterRequest(list);
                    return registerDTO;
                }).collect(Collectors.toList());
        return registerList;
    }
}

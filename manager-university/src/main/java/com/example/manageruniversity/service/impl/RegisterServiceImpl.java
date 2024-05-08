package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.RegisterMapper;
import com.example.manageruniversity.repository.RegisterRepository;
import com.example.manageruniversity.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegisterServiceImpl implements IRegisterService {

    private final RegisterRepository registerRepository;

    @Autowired
    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public RegisterDTO saveOrUpdate(RegisterDTO registerDTO) {
        Register register = RegisterMapper.mapper.registerDTOToEntity(registerDTO);
        registerRepository.save(register);
        return null;
    }

    @Override
    public List<RegisterDTO> records() {
        List<Register> registers = registerRepository.findAll();
        return convertList(registers)   ;
    }

    @Override
    public void delete(Long id) {
        registerRepository.deleteById(id);
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
    public List<RegisterDTO> getRegisterByStudentIdAndSeasonDisabled(Long studentId, boolean disabled) {
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
                    for(Register r : register.getRegisterListRequestFromStudent()) {
                        r.setTransactions(new ArrayList<>());
                        list.add(RegisterMapper.mapper.registerToDTO(r));
                    }
                    registerDTO.setListRegisterRequest(list);
                    return registerDTO;
                }).collect(Collectors.toList());
        return registerList;
    }
}

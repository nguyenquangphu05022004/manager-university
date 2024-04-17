package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.mapper.RegisterMapper;
import com.example.manageruniversity.repository.RegisterRepository;
import com.example.manageruniversity.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        register = registerRepository.save(register);
        return RegisterMapper.mapper.registerToDTO(register);
    }

    @Override
    public List<RegisterDTO> records() {
        List<Register> registers = registerRepository.findAll();
        return registers.stream().map(register -> {
            return RegisterMapper.mapper.registerToDTO(register);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        registerRepository.deleteById(id);
    }
}

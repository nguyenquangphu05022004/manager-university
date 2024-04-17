package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.entity.MajorRegister;
import com.example.manageruniversity.mapper.MajorRegisterMapper;
import com.example.manageruniversity.repository.MajorRegisterRepository;
import com.example.manageruniversity.service.IMajorRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MajorRegisterServiceImpl implements IMajorRegisterService {
    private final MajorRegisterRepository majorRegisterRepository;

    @Autowired
    public MajorRegisterServiceImpl(MajorRegisterRepository majorRegisterRepository) {
        this.majorRegisterRepository = majorRegisterRepository;
    }

    @Override
    public MajorRegisterDTO saveOrUpdate(MajorRegisterDTO majorRegisterDTO) {
        MajorRegister majorRegister = null;
        if(majorRegisterDTO.getId() != null) {
        } else {
            majorRegister = MajorRegisterMapper.mapper.majorRegisterDTOToEntity(majorRegisterDTO);
        }
        majorRegister = majorRegisterRepository.save(majorRegister);
        return MajorRegisterMapper.mapper.majorRegisterToDTO(majorRegister);
    }

    @Override
    public List<MajorRegisterDTO> records() {
        List<MajorRegister> majorRegisters = majorRegisterRepository.findAll();
        return majorRegisters.stream().map(majorRegister -> {
            return MajorRegisterMapper.mapper.majorRegisterToDTO(majorRegister);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        majorRegisterRepository.deleteById(id);
    }

    @Override
    public MajorRegisterDTO findByMajorIdAndIsBlock(Long majorId) {
        MajorRegister majorRegister = majorRegisterRepository.findByMajorIdAndIsBlock(majorId, false);
        return MajorRegisterMapper.mapper.majorRegisterToDTO(majorRegister);
    }
}

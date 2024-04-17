package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.entity.Major;
import com.example.manageruniversity.mapper.MajorMapper;
import com.example.manageruniversity.repository.MajorRepository;
import com.example.manageruniversity.service.IMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MajorServiceImpl implements IMajorService {
    private final MajorRepository majorRepository;

    @Autowired
    public MajorServiceImpl(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    @Override
    public MajorDTO saveOrUpdate(MajorDTO majorDTO) {
        Major major = null;
        if(majorDTO.getId() != null) {

        } else {
            major = MajorMapper.mapper.majorDTOToEntity(majorDTO);
        }
        major = majorRepository.save(major);
        return MajorMapper.mapper.majorToDTO(major);
    }

    @Override
    public List<MajorDTO> records() {
        List<Major> majors = majorRepository.findAll();
        return majors.stream().map(major -> {
            return MajorMapper.mapper.majorToDTO(major);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        majorRepository.deleteById(id);
    }

}

package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.SchoolYearDTO;
import com.example.manageruniversity.entity.SchoolYear;
import com.example.manageruniversity.mapper.SchoolYearMapper;
import com.example.manageruniversity.repository.SchoolYearRepository;
import com.example.manageruniversity.service.ISchoolYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolYearServiceImpl implements ISchoolYearService {


    private final SchoolYearRepository schoolYearRepository;

    @Autowired
    public SchoolYearServiceImpl(SchoolYearRepository schoolYearRepository) {
        this.schoolYearRepository = schoolYearRepository;
    }

    @Override
    public SchoolYearDTO saveOrUpdate(SchoolYearDTO schoolYearDTO) {
        SchoolYear schoolYear = null;
        if(schoolYearDTO.getId() != null) {

        } else {
            schoolYear = SchoolYearMapper.mapper.schoolYearDTOToEntity(schoolYearDTO);
        }
        schoolYear = schoolYearRepository.save(schoolYear);
        return SchoolYearMapper.mapper.schoolYearToDTO(schoolYear);
    }

    @Override
    public List<SchoolYearDTO> records() {
        List<SchoolYear> schoolYears = schoolYearRepository.findAll();
        return schoolYears.stream().map(schoolYear -> {
            return SchoolYearMapper.mapper.schoolYearToDTO(schoolYear);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        schoolYearRepository.deleteById(id);
    }
}

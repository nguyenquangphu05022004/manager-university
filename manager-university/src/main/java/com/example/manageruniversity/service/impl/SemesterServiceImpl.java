package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.SemesterDTO;
import com.example.manageruniversity.entity.Semester;
import com.example.manageruniversity.mapper.SemesterMapper;
import com.example.manageruniversity.repository.SemesterRepository;
import com.example.manageruniversity.service.ISemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SemesterServiceImpl implements ISemesterService {


    private final SemesterRepository semesterRepository;

    @Autowired
    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @Override
    public SemesterDTO saveOrUpdate(SemesterDTO semesterDTO) {
        Semester semester = null;
        if(semesterDTO.getId() != null) {

        } else {
            semester = SemesterMapper.mapper.semesterDTOToEntity(semesterDTO);
        }
        semester = semesterRepository.save(semester);
        return SemesterMapper.mapper.semesterToDTO(semester);
    }

    @Override
    public List<SemesterDTO> records() {
        List<Semester> semesters = semesterRepository.findAll();
        return semesters.stream().map(semester -> {
            return SemesterMapper.mapper.semesterToDTO(semester);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        semesterRepository.deleteById(id);
    }
}

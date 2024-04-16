package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.entity.Subject;
import com.example.manageruniversity.mapper.SubjectMapper;
import com.example.manageruniversity.repository.SubjectRepository;
import com.example.manageruniversity.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements ISubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public SubjectDTO saveOrUpdate(SubjectDTO subjectDTO) {
        Subject subject = null;
        if(subjectDTO.getId() != null) {

        } else {
            subject = SubjectMapper.mapper.subjectDTOToEntity(subjectDTO);
        }
        subject = subjectRepository.save(subject);
        return SubjectMapper.mapper.subjectToDTO(subject);
    }

    @Override
    public List<SubjectDTO> records() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().map(subject -> {
            return SubjectMapper.mapper.subjectToDTO(subject);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
}

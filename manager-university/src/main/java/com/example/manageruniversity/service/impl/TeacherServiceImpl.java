package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.TeacherDTO;
import com.example.manageruniversity.entity.Teacher;
import com.example.manageruniversity.mapper.TeacherMapper;
import com.example.manageruniversity.repository.TeacherRepository;
import com.example.manageruniversity.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements ITeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherDTO saveOrUpdate(TeacherDTO teacherDTO) {
        Teacher teacher = null;
        if (teacherDTO.getId() != null) {

        } else {
            teacher = TeacherMapper.mapper.teacherDTOToEntity(teacherDTO);
        }
        teacher = teacherRepository.save(teacher);
        return TeacherMapper.mapper.teacherToDTO(teacher);
    }

    @Override
    public List<TeacherDTO> records() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(teacher -> {
            return TeacherMapper.mapper.teacherToDTO(teacher);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }
}

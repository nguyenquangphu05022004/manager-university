package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.StudentDTO;
import com.example.manageruniversity.entity.Student;
import com.example.manageruniversity.mapper.StudentMapper;
import com.example.manageruniversity.repository.StudentRepository;
import com.example.manageruniversity.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO saveOrUpdate(StudentDTO studentDTO) {
        if(studentDTO == null) return null;
        Student student = null;
        if(studentDTO.getId() != null) {

        } else {
            student = StudentMapper.mapper.studentDTOToEntity(studentDTO);

        }
        student = studentRepository.save(student);
        return StudentMapper.mapper.studentToDTO(student);
    }

    @Override
    public List<StudentDTO> records() {
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream().map(student -> {
            return StudentMapper.mapper.studentToDTO(student);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDTO> getListStudentBySubjectGroupId(Long subjectGroupId) {
        List<Student> studentList = studentRepository.findAllBySubjectGroupId(subjectGroupId);
        return studentList.stream().map(student -> {
            return StudentMapper.mapper.studentToDTO(student);
        }).collect(Collectors.toList());
    }
}

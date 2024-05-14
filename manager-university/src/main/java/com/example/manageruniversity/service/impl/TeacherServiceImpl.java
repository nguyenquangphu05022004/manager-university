package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.dto.TeacherDTO;
import com.example.manageruniversity.entity.Teacher;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.RegisterMapper;
import com.example.manageruniversity.mapper.SubjectGroupMapper;
import com.example.manageruniversity.mapper.TeacherMapper;
import com.example.manageruniversity.repository.RegisterRepository;
import com.example.manageruniversity.repository.TeacherRepository;
import com.example.manageruniversity.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements ITeacherService {
    private final TeacherRepository teacherRepository;
    private final RegisterRepository registerRepository;


    @Override
    public TeacherDTO saveOrUpdate(TeacherDTO teacherDTO) {
        if (teacherDTO == null) return null;
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

    @Override
    public TeacherDTO findById(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new NotFoundIdException("Teacher", "Id", "" + teacherId));
        List<SubjectGroupDTO> subjectGroupDTOS = teacher
                .getSubjectGroups()
                .stream()
                .map(e -> {
                    e.setTeacher(null);
                    List<RegisterDTO> registerList = registerRepository
                            .findAllBySubjectGroupIdAndSeasonNotDisabled(e.getId())
                            .stream().map(r -> {
                                r.setSubjectGroup(null);
                                return RegisterMapper.mapper.registerToDTO(r);
                            }).toList();
                    SubjectGroupDTO subGroup = SubjectGroupMapper.mapper.subjectGroupToDTO(e);
                    subGroup.setRegisterDTOS(registerList);
                    return subGroup;
                })
                .toList();
        TeacherDTO teacherDTO = TeacherMapper.mapper.teacherToDTO(teacher);
        teacherDTO.setSubjectGroupDTOS(subjectGroupDTOS);
        return teacherDTO;
    }
}

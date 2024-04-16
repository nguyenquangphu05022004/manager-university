package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.dto.TeacherDTO;
import com.example.manageruniversity.entity.Subject;
import com.example.manageruniversity.entity.SubjectGroup;
import com.example.manageruniversity.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper mapper = Mappers.getMapper(TeacherMapper.class);

    @Mapping(target = "subjects", source = "teacherDTO.subjectDTOS")
    Teacher teacherDTOToEntity(TeacherDTO teacherDTO);

    @Mapping(target = "subjectDTOS", source = "teacher.subjects")
    TeacherDTO teacherToDTO(Teacher teacher);

    @Mapping(target = "subjectGroupDTOS", source = "subject.subjectGroups")
    SubjectDTO subjectToDTO(Subject subject);
    Subject subjectDTOToEntity(SubjectDTO subjectDTO);

    SubjectGroupDTO subjectGroupToDTO(SubjectGroup subjectGroup);
}

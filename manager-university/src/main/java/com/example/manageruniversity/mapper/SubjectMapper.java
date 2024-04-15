package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.dto.TuitionDTO;
import com.example.manageruniversity.entity.Subject;
import com.example.manageruniversity.entity.SubjectGroup;
import com.example.manageruniversity.entity.Tuition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectMapper {
    SubjectMapper mapper = Mappers.getMapper(SubjectMapper.class);

    Subject subjectDTOToEntity(SubjectDTO subjectDTO);
    @Mapping(target = "tuitionDTO", source = "subject.tuition")
    SubjectDTO subjectToDTO(Subject subject);

    TuitionDTO tuitionToDTO(Tuition tuition);

    SubjectGroupDTO subjectGroupToDTO(SubjectGroup subjectGroup);
}

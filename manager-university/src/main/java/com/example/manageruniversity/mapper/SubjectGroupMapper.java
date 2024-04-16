package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.entity.Subject;
import com.example.manageruniversity.entity.SubjectGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectGroupMapper {
    SubjectGroupMapper mapper = Mappers.getMapper(SubjectGroupMapper.class);

    @Mapping(target = "subject", source = "subjectGroupDTO.subjectDTO")
    SubjectGroup subjectGroupDTOToEntity(SubjectGroupDTO subjectGroupDTO);
    @Mapping(target = "subjectDTO", source = "subjectGroup.subject")
    SubjectGroupDTO subjectGroupToDTO(SubjectGroup subjectGroup);

    SubjectDTO subjectDTOToEntity(SubjectDTO subjectDTO);
    SubjectDTO subjectToDTO(Subject subject);
}

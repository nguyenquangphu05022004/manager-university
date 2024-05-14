package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.entity.SubjectGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectGroupMapper {
    SubjectGroupMapper mapper = Mappers.getMapper(SubjectGroupMapper.class);

    SubjectGroup subjectGroupDTOToEntity(SubjectGroupDTO subjectGroupDTO);
    SubjectGroupDTO subjectGroupToDTO(SubjectGroup subjectGroup);
}

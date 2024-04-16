package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SemesterDTO;
import com.example.manageruniversity.entity.Semester;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SemesterMapper {
    SemesterMapper mapper = Mappers.getMapper(SemesterMapper.class);

    Semester semesterDTOToEntity(SemesterDTO semesterDTO);
    SemesterDTO semesterToDTO(Semester semester);
}

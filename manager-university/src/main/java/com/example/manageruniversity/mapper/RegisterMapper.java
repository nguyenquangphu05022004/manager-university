package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.entity.Register;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegisterMapper {
    RegisterMapper mapper = Mappers.getMapper(RegisterMapper.class);

    @Mapping(target = "studentDTO", source = "register.student")
    @Mapping(target = "subjectGroupDTO", source = "register.subjectGroup")
    @Mapping(target = "subjectGroupDTO.subjectDTO", source = "register.subjectGroup.subject")
    RegisterDTO registerToDTO(Register register);

    @Mapping(target = "student", source = "registerDTO.studentDTO")
    @Mapping(target = "subjectGroup", source = "registerDTO.subjectGroupDTO")
    Register registerDTOToEntity(RegisterDTO registerDTO);
}
package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.entity.Register;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegisterMapper {
    RegisterMapper mapper = Mappers.getMapper(RegisterMapper.class);

    @Mapping(target = "studentDTO", source = "register.student")
    @Mapping(target = "subjectGroup", source = "register.subjectGroup")
    @Mapping(target = "subjectGroup.subject", source = "register.subjectGroup.subject")
    @Mapping(target = "majorRegisterDTO", source = "register.majorRegister")
    RegisterDTO registerToDTO(Register register);

    @Mapping(target = "student", source = "registerDTO.studentDTO")
    @Mapping(target = "subjectGroup", source = "registerDTO.subjectGroup")
    @Mapping(target = "majorRegister", source = "registerDTO.majorRegisterDTO")
    Register registerDTOToEntity(RegisterDTO registerDTO);
}
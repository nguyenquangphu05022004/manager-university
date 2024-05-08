package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.*;
import com.example.manageruniversity.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MajorRegisterMapper {

    MajorRegisterMapper mapper = Mappers.getMapper(MajorRegisterMapper.class);
    @Mapping(target = "major", source = "majorRegisterDTO.majorDTO")
    @Mapping(target = "season", source = "majorRegisterDTO.seasonDTO")
    @Mapping(target = "subjects", source = "majorRegisterDTO.subjectDTOS")
    MajorRegister majorRegisterDTOToEntity(MajorRegisterDTO majorRegisterDTO);
    @Mapping(target = "majorDTO", source = "majorRegister.major")
    @Mapping(target = "seasonDTO", source = "majorRegister.season")
    @Mapping(target = "subjectDTOS", source = "majorRegister.subjects")
    @Mapping(target = "registerDTOS", source = "majorRegister.registers")
    @Mapping(target = "tuitionDTO", source = "majorRegister.tuition")
    MajorRegisterDTO majorRegisterToDTO(MajorRegister majorRegister);


}

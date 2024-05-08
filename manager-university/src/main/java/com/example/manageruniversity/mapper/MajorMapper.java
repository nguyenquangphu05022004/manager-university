package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.entity.Major;
import com.example.manageruniversity.entity.MajorRegister;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MajorMapper {
    MajorMapper mapper = Mappers.getMapper(MajorMapper.class);

    Major majorDTOToEntity(MajorDTO majorDTO);
    @Mapping(target = "majorRegisterDTOS", source = "major.majorRegisters")
    MajorDTO majorToDTO(Major major);

    @Mapping(target = "subjectDTOS", source = "majorRegister.subjects")
    @Mapping(target = "seasonDTO", source = "majorRegister.season")
    MajorRegisterDTO majorRegisterToDto(MajorRegister majorRegister);
}

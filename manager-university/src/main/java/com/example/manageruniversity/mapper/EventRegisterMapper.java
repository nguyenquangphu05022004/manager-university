package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.EventRegisterDTO;
import com.example.manageruniversity.entity.EventRegister;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventRegisterMapper {
    EventRegisterMapper mapper = Mappers.getMapper(EventRegisterMapper.class);

    @Mapping(target = "majors", source = "event.majorDTOS")
    @Mapping(target = "season", source = "event.seasonDTO")
    EventRegister toEntity(EventRegisterDTO event);

    @Mapping(target = "majorDTOS", source = "event.majors")
    @Mapping(target = "seasonDTO", source = "event.season")
    EventRegisterDTO toDto(EventRegister event);
}

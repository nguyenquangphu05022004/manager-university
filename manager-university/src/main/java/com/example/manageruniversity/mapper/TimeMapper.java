package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.RoomClassDTO;
import com.example.manageruniversity.dto.TimeDTO;
import com.example.manageruniversity.entity.RoomClass;
import com.example.manageruniversity.entity.Time;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TimeMapper {
    TimeMapper mapper = Mappers.getMapper(TimeMapper.class);

    Time timeDTOToEntity(TimeDTO timeDTO);
    @Mapping(target = "roomClassDTO", source = "time.roomClass")
    TimeDTO timeToDTO(Time time);

    RoomClassDTO roomClassToDTO(RoomClass roomClass);
}

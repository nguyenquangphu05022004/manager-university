package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.RoomClassDTO;
import com.example.manageruniversity.dto.TimeDTO;
import com.example.manageruniversity.entity.RoomClass;
import com.example.manageruniversity.entity.Time;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomClassMapper {
    RoomClassMapper mapper = Mappers.getMapper(RoomClassMapper.class);

    @Mapping(target = "id",source = "roomClassDTO.id")
    RoomClass roomClassDTOToEntity(RoomClassDTO roomClassDTO);

    @Mapping(target = "timeDTOS", source = "roomClass.times")
    RoomClassDTO roomClassToDTO(RoomClass roomClass);

}

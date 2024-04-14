package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.entity.Courses;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CoursesMapper {

    CoursesMapper mapper = Mappers.getMapper(CoursesMapper.class);

    @Mapping(target = "id", source = "courses.id")
    CoursesDTO coursesToDTO(Courses courses);
    Courses coursesDTOtoEntity(CoursesDTO coursesDTO);

}

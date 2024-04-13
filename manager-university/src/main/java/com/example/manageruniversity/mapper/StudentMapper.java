package com.example.manageruniversity.mapper;


import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.dto.StudentDTO;
import com.example.manageruniversity.entity.Major;
import com.example.manageruniversity.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper mapper = Mappers.getMapper(StudentMapper.class);


    @Mapping(target = "fullName", source = "dto.fullName")
    @Mapping(target = "address", source = "dto.address")
    @Mapping(target = "username", source = "dto.username")
    @Mapping(target = "password", source = "dto.password")
    @Mapping(target = "dateOfBirth", source = "dto.dateOfBirth")
    @Mapping(target = "sex", source = "dto.sex")
    @Mapping(target = "major", source = "dto.majorDTO")
    Student studentDTOToEntity(StudentDTO dto);
    StudentDTO studentEntityTodTO(Student student);

    @Mapping(target = "id", source = "dto.id")
    Major majorDTOToEntity(MajorDTO dto);


}

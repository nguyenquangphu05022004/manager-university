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


    Student studentDTOToEntity(StudentDTO dto);

    StudentDTO studentToDTO(Student student);

}

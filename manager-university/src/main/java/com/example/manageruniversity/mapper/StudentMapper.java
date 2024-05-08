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


    @Mapping(target = "major", source = "dto.majorDTO")
    Student studentDTOToEntity(StudentDTO dto);

    @Mapping(target = "majorDTO", source = "student.major")
    @Mapping(target = "coursesDTO", source = "student.courses")
    StudentDTO studentToDTO(Student student);

}

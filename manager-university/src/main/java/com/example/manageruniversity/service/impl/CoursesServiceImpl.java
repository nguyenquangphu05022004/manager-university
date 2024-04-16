package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.entity.Courses;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.CoursesMapper;
import com.example.manageruniversity.repository.CoursesRepository;
import com.example.manageruniversity.service.ICoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursesServiceImpl implements ICoursesService {

    private final CoursesRepository coursesRepository;

    @Autowired
    public CoursesServiceImpl(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public CoursesDTO saveOrUpdate(CoursesDTO coursesDTO) {
        Courses coursesNew = null;
        if(coursesDTO.getId() != null) {
            Courses courses = coursesRepository.findById(coursesDTO.getId()).orElseThrow(() -> {
                return new NotFoundIdException("Courses", "Id", coursesDTO.getId().toString());
            });
        } else {
            coursesNew = CoursesMapper.mapper.coursesDTOtoEntity(coursesDTO);
        }
        Courses coursesSave = coursesRepository.save(coursesNew);
        return CoursesMapper.mapper.coursesToDTO(coursesSave);
    }

    @Override
    public List<CoursesDTO> records() {
        List<Courses> courses =  coursesRepository.findAll();
        return courses.stream().map(course -> {
            return CoursesMapper.mapper.coursesToDTO(course);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        coursesRepository.deleteById(id);
    }
}

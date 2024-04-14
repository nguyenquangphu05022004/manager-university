package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.service.ICoursesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {

    private ICoursesService coursesService;

    @PostMapping("/api/courses")
    public CoursesDTO createCourses(@RequestBody CoursesDTO coursesDTO) {
        return coursesService.saveOrUpdate(coursesDTO);
    }
    @PutMapping("/api/courses/{coursesId}")
    public CoursesDTO updateCourses(@PathVariable("coursesId") Long coursesId,
                                    @RequestBody CoursesDTO coursesDTO) {
        coursesDTO.setId(coursesId);
        return coursesService.saveOrUpdate(coursesDTO);
    }
    @GetMapping("/api/courses")
    public List<CoursesDTO> coursesList() {
        return coursesService.records();
    }
    @DeleteMapping("/api/courses/{coursesId}")
    public void deleteCourses(@PathVariable("coursesId") Long coursesId) {
        coursesService.delete(coursesId);
    }

}

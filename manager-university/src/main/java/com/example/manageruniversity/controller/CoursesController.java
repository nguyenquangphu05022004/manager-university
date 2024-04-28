package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.service.ICoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class CoursesController {

    private final ICoursesService coursesService;

    @Autowired
    public CoursesController(ICoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @PostMapping("/courses")
    public CoursesDTO createCourses(@RequestBody CoursesDTO coursesDTO) {
        return coursesService.saveOrUpdate(coursesDTO);
    }
    @PutMapping("/courses/{coursesId}")
    public CoursesDTO updateCourses(@PathVariable("coursesId") Long coursesId,
                                    @RequestBody CoursesDTO coursesDTO) {
        coursesDTO.setId(coursesId);
        return coursesService.saveOrUpdate(coursesDTO);
    }
    @GetMapping("/courses")
    public List<CoursesDTO> coursesList() {
        return coursesService.records();
    }
    @DeleteMapping("/courses/{coursesId}")
    public void deleteCourses(@PathVariable("coursesId") Long coursesId) {
        coursesService.delete(coursesId);
    }

}

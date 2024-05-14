package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.ComponentGradeDTO;
import com.example.manageruniversity.dto.GradeDTO;
import com.example.manageruniversity.service.IGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grades")
@CrossOrigin("*")
@RequiredArgsConstructor
public class GradeController {
    private final IGradeService gradeService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateGrade(@RequestParam("subjectCode") String subjectCode,
                            @RequestParam("studentCode") String studentCode,
                            @RequestBody GradeDTO gradeDTO) {
        gradeService.saveOrUpdate(gradeDTO, subjectCode, studentCode);
    }
    @GetMapping("/grade-component")
    public List<ComponentGradeDTO> getListGradeComponent() {
        return gradeService.getListGradeComponent();
    }
    @PostMapping("/init")
    public void initGrade(@RequestParam("majorRegisterId") Long majorRegisterId) {
        gradeService.initGradeByMajorRegisterId(majorRegisterId);
    }
}

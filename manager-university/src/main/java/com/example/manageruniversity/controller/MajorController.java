package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.service.IMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class MajorController {
    private final IMajorService majorService;

    @Autowired
    public MajorController(IMajorService majorService) {
        this.majorService = majorService;
    }

    @PostMapping("/majors")
    public MajorDTO createMajor(@RequestBody MajorDTO majorDTO) {
        return majorService.saveOrUpdate(majorDTO);
    }
    @PutMapping("/majors/{majorId}")
    public MajorDTO updateMajor(@RequestBody MajorDTO majorDTO,
                                @PathVariable("majorId") Long majorId) {
        majorDTO.setId(majorId);
        return majorService.saveOrUpdate(majorDTO);
    }

    @GetMapping("/majors")
    public List<MajorDTO> majorList() {
        return majorService.records();
    }

    @DeleteMapping("/majors/{majorId}")
    public void deleteMajor(@PathVariable("majorId") Long majorId) {
        majorService.delete(majorId);
    }


}

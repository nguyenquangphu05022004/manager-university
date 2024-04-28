package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.TuitionDTO;
import com.example.manageruniversity.service.ITuitionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tuitions")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TuitionController {
    private final ITuitionService tuitionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTuition(@RequestBody TuitionDTO tuitionDTO) {
         tuitionService.saveOrUpdate(tuitionDTO);
    }
    @GetMapping
    public List<TuitionDTO> listTuition() {
        return tuitionService.listTuition();
    }

}

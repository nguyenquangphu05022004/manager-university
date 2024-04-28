package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.TimeDTO;
import com.example.manageruniversity.service.ITimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class TimeController {
    private final ITimeService timeService;

    @Autowired
    public TimeController(ITimeService timeService) {
        this.timeService = timeService;
    }

    @PostMapping("/times")
    public TimeDTO createTime(@RequestBody TimeDTO timeDTO) {
        return timeService.saveOrUpdate(timeDTO);
    }
    @PutMapping("/times/{timeId}")
    public TimeDTO updateTime(@PathVariable("timeId") Long timeId,
                              @RequestBody TimeDTO timeDTO) {
        timeDTO.setId(timeId);
        return timeService.saveOrUpdate(timeDTO);
    }
    @DeleteMapping("/times/{timeId}")
    public void deleteTime(@PathVariable("timeId") Long timeId) {
        timeService.delete(timeId);
    }
    @GetMapping("/times")
    public List<TimeDTO> timeList() {
        return timeService.records();
    }
}

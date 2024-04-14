package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.TimeDTO;
import com.example.manageruniversity.service.ITimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeController {
    private final ITimeService timeService;

    @Autowired
    public TimeController(ITimeService timeService) {
        this.timeService = timeService;
    }

    @PostMapping("/api/times")
    public TimeDTO createTime(@RequestBody TimeDTO timeDTO) {
        return timeService.saveOrUpdate(timeDTO);
    }
    @PutMapping("/api/times/{timeId}")
    public TimeDTO updateTime(@PathVariable("timeId") Long timeId,
                              @RequestBody TimeDTO timeDTO) {
        timeDTO.setId(timeId);
        return timeService.saveOrUpdate(timeDTO);
    }
    @DeleteMapping("/api/times/{timeId}")
    public void deleteTime(@PathVariable("timeId") Long timeId) {
        timeService.delete(timeId);
    }
    @GetMapping("/api/times")
    public List<TimeDTO> timeList() {
        return timeService.records();
    }
}

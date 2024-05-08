package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.EventRegisterDTO;
import com.example.manageruniversity.service.IEventRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class EventRegisterController {
    private final IEventRegisterService eventRegisterService;

    @PostMapping("/events")
    public void createEventRegister(@RequestBody EventRegisterDTO eventRegisterDTO) {
        eventRegisterService.saveOrUpdate(eventRegisterDTO);
    }
    @GetMapping("/events")
    public List<EventRegisterDTO> getListEventRegister()  {
        return eventRegisterService.records();
    }
}

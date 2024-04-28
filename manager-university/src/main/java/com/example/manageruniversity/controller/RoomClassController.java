package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.RoomClassDTO;
import com.example.manageruniversity.service.IRoomClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class RoomClassController {
    private final IRoomClassService roomClassService;

    @Autowired
    public RoomClassController(IRoomClassService roomClassService) {
        this.roomClassService = roomClassService;
    }
    @PostMapping("/roomClasses")
    public RoomClassDTO createRoomClass(@RequestBody RoomClassDTO roomClassDTO) {
        return roomClassService.saveOrUpdate(roomClassDTO);
    }
    @PutMapping("/roomClasses/{roomClassId}")
    public RoomClassDTO updateRoomClass(@PathVariable("roomClassId") Long roomClassId,
                                        @RequestBody RoomClassDTO roomClassDTO) {
        roomClassDTO.setId(roomClassId);
        return roomClassService.saveOrUpdate(roomClassDTO);
    }
    @DeleteMapping("/roomClasses/{roomClassId}")
    public void deleteRoomClass(@PathVariable("roomClassId") Long roomClassId) {
        roomClassService.delete(roomClassId);
    }
    @GetMapping("/roomClasses")
    public List<RoomClassDTO> roomClassList() {
        return roomClassService.records();
    }
}

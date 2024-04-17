package com.example.manageruniversity.controller;
import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.service.IMajorRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MajorRegisterController {
    private final IMajorRegisterService majorRegisterService;

    @Autowired
    public MajorRegisterController(IMajorRegisterService majorRegisterService) {
        this.majorRegisterService = majorRegisterService;
    }

    @PostMapping("/api/majorRegisters")
    public MajorRegisterDTO createMajorRegister(@RequestBody MajorRegisterDTO majorRegisterDTO) {
        return majorRegisterService.saveOrUpdate(majorRegisterDTO);
    }
    @PutMapping("/api/majorRegisters/{majorRegisterId}")
    public MajorRegisterDTO createMajorRegister(@RequestBody MajorRegisterDTO majorRegisterDTO,
                                                @PathVariable("majorRegisterId") Long majorRegisterId) {
        return majorRegisterService.saveOrUpdate(majorRegisterDTO);
    }
    @DeleteMapping("/api/majorRegisters/{majorRegisterId}")
    public void deleteMajorRegister(@PathVariable("majorRegisterId") Long majorRegisterId) {
        majorRegisterService.delete(majorRegisterId);
    }
    @GetMapping("/api/majorRegisters")
    public List<MajorRegisterDTO> majorRegisterList() {
        return majorRegisterService.records();
    }

    @GetMapping("/api/majorRegisters/major/{majorId}")
    public MajorRegisterDTO getByMajorIdAndIsBlockIsFalse(@PathVariable("majorId") Long majorId) {
        return majorRegisterService.findByMajorIdAndIsBlock(majorId);
    }
}

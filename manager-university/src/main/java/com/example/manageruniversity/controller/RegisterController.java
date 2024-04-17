package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisterController {
    private final IRegisterService registerService;

    @Autowired
    public RegisterController(IRegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/api/registers")
    public RegisterDTO createRegister(@RequestBody RegisterDTO registerDTO) {
        return registerService.saveOrUpdate(registerDTO);
    }
    @DeleteMapping("/api/register/{registerId}")
    public void deleteRegister(@PathVariable("registerId") Long registerId) {
        registerService.delete(registerId);
    }
    @GetMapping("/api/registers")
    public List<RegisterDTO> registerList() {
        return registerService.records();
    }
}

package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.service.IRegisterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class RegisterController {
    private final IRegisterService registerService;

    @Autowired
    public RegisterController(IRegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/registers")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterDTO createRegister(@RequestBody RegisterDTO registerDTO) {

        return registerService.saveOrUpdate(registerDTO);
    }
    @DeleteMapping("/registers/{registerId}")
    public void deleteRegister(@PathVariable("registerId") Long registerId) {
        registerService.delete(registerId);
    }

    @GetMapping("/registers/student/{studentId}")
    public List<RegisterDTO> getRegisterListByStudentIdAndSeasonNotDisable(@PathVariable("studentId") Long studentId,
                                                                           @RequestParam("disabled") boolean disabled,
                                                                           HttpServletResponse response) {
        return registerService.getRegisterByStudentIdAndSeasonDisabled(studentId, disabled, response);
    }

    @PutMapping("/registers/transaction/{registerId}")
    public ResponseEntity<?> transaction(@PathVariable("registerId") Long registerId,
                                         @RequestParam("transaction") boolean transaction) {
         registerService.transaction(registerId, transaction);
         return ResponseEntity.ok("Register with Id: " + registerId + " was "+ (transaction ? "opened" : "closed")  +  " transaction");
    }
    @GetMapping("/registers/transaction")
    public List<RegisterDTO> registerListByTransaction(@RequestParam("transaction") boolean transaction) {
        return registerService.recordsByTransactionStatus(transaction);
    }
    @GetMapping("/registers/student/{studentId}/subject/{subjectId}")
    public List<RegisterDTO> getListRegisterOpenedTransactionBySubjectIdAndNotOfStudentId(@PathVariable("studentId") Long studentId,
                                                                         @PathVariable("subjectId") Long subjectId) {
        return registerService.findAllRegisterOpenedBySubjectIdAndNotOfStudentId(subjectId, studentId);
    }
}

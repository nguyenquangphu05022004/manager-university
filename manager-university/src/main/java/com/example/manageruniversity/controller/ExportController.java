package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.export.StudentExport;
import com.example.manageruniversity.service.IStudentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/export")
@CrossOrigin("*")
public class ExportController {
    private final IStudentService studentService;

    @GetMapping(value = "/students")
    public void listStudentExportToExcel(HttpServletResponse response,
                                         @RequestParam("fileName") String fileName,
                                         @RequestParam("subjectGroupId") Long subjectGroupId) throws IOException {
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName + ".xlsx");
        response.setContentType(String.valueOf(MediaType.APPLICATION_OCTET_STREAM));
        StudentExport studentExport = new StudentExport(studentService.getListStudentBySubjectGroupId(subjectGroupId), fileName  );
        studentExport.export(studentExport.getHeaders(), response);
    }
}

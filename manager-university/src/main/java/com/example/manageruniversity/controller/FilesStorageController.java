package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.AvatarResponse;
import com.example.manageruniversity.service.IFilesStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class FilesStorageController {
    private final IFilesStorageService filesStorageService;

    @PostMapping(value = "/file/uploads", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AvatarResponse uploadFiles(@RequestParam("file")MultipartFile multipartFile) {
        return filesStorageService.uploads(multipartFile);
    }
    @GetMapping(value = "/file/{fileName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Resource getFile(@PathVariable("fileName") String fileName) {
        return filesStorageService.readFile(fileName);
    }
}

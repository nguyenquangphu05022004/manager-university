package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.AvatarResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IFilesStorageService {
    AvatarResponse uploads(MultipartFile multipartFile);
    Resource readFile(String fileName);
}

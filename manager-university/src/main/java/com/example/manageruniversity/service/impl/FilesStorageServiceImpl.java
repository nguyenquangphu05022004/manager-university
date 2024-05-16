package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.AvatarResponse;
import com.example.manageruniversity.entity.Avatar;
import com.example.manageruniversity.entity.auth.User;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.repository.AvatarRepository;
import com.example.manageruniversity.repository.auth.UserRepository;
import com.example.manageruniversity.service.IFilesStorageService;
import com.example.manageruniversity.utils.SystemUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class FilesStorageServiceImpl implements IFilesStorageService {

    private final AvatarRepository avatarRepository;
    private final UserRepository userRepository;
    private final Path path = Paths.get(SystemUtils.FOLDER_STORAGE_FILE);

    @Override
    @Transactional
    public AvatarResponse uploads(MultipartFile multipartFile) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path.
                    resolve(multipartFile.getOriginalFilename())
                    .toUri().getPath());
            User user = userRepository
                    .findByUsername(SystemUtils.getUsername())
                    .orElseThrow(() -> new NotFoundIdException("user", "username", SystemUtils.getUsername()));
            Avatar avatar = new Avatar(multipartFile.getOriginalFilename(),
                    SystemUtils.FOLDER_STORAGE_FILE,
                    user);
            if(user.getAvatar() != null) {
                delete(user.getAvatar().getAvatarName());
                avatar = user.getAvatar();
                avatar.setAvatarName(multipartFile.getOriginalFilename());
            }
            fileOut.write(multipartFile.getBytes());
            avatarRepository.save(avatar);
            return AvatarResponse.builder()
                    .fileName(avatar.getAvatarName())
                    .folderStorage(avatar.getFolderStorage())
                    .build();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String fileName) {
        try {
            Files.delete(path.resolve(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Resource readFile(String fileName) {
        try {
            FileInputStream fileInput = new FileInputStream(path.resolve(fileName).toUri().getPath());
            Resource resource = new ByteArrayResource(fileInput.readAllBytes());
            return resource;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

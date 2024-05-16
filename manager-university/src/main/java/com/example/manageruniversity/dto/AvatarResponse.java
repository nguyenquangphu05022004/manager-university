package com.example.manageruniversity.dto;

import com.example.manageruniversity.controller.FilesStorageController;
import lombok.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AvatarResponse {
    private String fileName;
    private String folderStorage;

    public String getUrl() {
        if(fileName != null) {
            return MvcUriComponentsBuilder.fromMethodName(FilesStorageController.class,
                            "getFile", fileName)
                    .build()
                    .toString();
        }
        return "https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg";
    }
}

package com.example.manageruniversity.dto.auth;

import com.example.manageruniversity.entity.Role;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;
}

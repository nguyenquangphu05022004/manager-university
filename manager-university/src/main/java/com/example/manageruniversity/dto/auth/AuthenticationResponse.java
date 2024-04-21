package com.example.manageruniversity.dto.auth;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String accessToken;
}

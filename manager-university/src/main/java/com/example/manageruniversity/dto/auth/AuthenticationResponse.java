package com.example.manageruniversity.dto.auth;

import com.example.manageruniversity.dto.StudentDTO;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String accessToken;
    private Object person;

}

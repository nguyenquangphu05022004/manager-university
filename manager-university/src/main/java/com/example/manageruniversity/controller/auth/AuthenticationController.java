package com.example.manageruniversity.controller.auth;
import com.example.manageruniversity.dto.auth.AuthenticationRequest;
import com.example.manageruniversity.dto.auth.AuthenticationResponse;
import com.example.manageruniversity.dto.auth.RegisterRequest;
import com.example.manageruniversity.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }
    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authRequest) {
        return authService.authenticate(authRequest);
    }

}

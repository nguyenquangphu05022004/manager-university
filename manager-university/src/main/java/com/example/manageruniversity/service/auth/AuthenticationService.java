package com.example.manageruniversity.service.auth;

import com.example.manageruniversity.dto.auth.AuthenticationRequest;
import com.example.manageruniversity.dto.auth.AuthenticationResponse;
import com.example.manageruniversity.entity.User;
import com.example.manageruniversity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(AuthenticationRequest authRequest) {
        User user = User.builder()
                .role(authRequest.getRole())
                .username(authRequest.getUsername())
                .password(passwordEncoder.encode(authRequest.getPassword()))
                .build();
        userRepository.save(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtService.generateToken(user))
                .build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        User user = userRepository.findByUsername(authRequest.getUsername()).orElseThrow();
        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(token)
                .build();
    }
}

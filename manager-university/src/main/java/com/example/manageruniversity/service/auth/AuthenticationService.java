package com.example.manageruniversity.service.auth;

import com.example.manageruniversity.dto.auth.AuthenticationRequest;
import com.example.manageruniversity.dto.auth.AuthenticationResponse;
import com.example.manageruniversity.entity.auth.Token;
import com.example.manageruniversity.entity.auth.TokenType;
import com.example.manageruniversity.entity.auth.User;
import com.example.manageruniversity.repository.auth.TokenRepository;
import com.example.manageruniversity.repository.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;
    @Transactional
    public AuthenticationResponse register(AuthenticationRequest authRequest) {
        User user = User.builder()
                .role(authRequest.getRole())
                .username(authRequest.getUsername())
                .password(passwordEncoder.encode(authRequest.getPassword()))
                .build();
        User userSaved = userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        saveToken(userSaved, jwt);
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .build();
    }

    private void saveToken(User user, String jwt) {
        Token token = Token.builder()
                .user(user)
                .token(jwt)
                .expired(false).revoked(false)
                .tokenType(TokenType.BEARER)
                .build();
        tokenRepository.save(token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        User user = userRepository.findByUsername(authRequest.getUsername()).orElseThrow();
        var jwt = jwtService.generateToken(user);
        saveToken(user, jwt);
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .build();
    }
}

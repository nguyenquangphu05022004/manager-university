package com.example.manageruniversity.service.auth;

import com.example.manageruniversity.dto.StudentDTO;
import com.example.manageruniversity.dto.TeacherDTO;
import com.example.manageruniversity.dto.auth.AuthenticationRequest;
import com.example.manageruniversity.dto.auth.AuthenticationResponse;
import com.example.manageruniversity.dto.auth.RegisterRequest;
import com.example.manageruniversity.entity.Role;
import com.example.manageruniversity.entity.auth.Token;
import com.example.manageruniversity.entity.auth.TokenType;
import com.example.manageruniversity.entity.auth.User;
import com.example.manageruniversity.mapper.StudentMapper;
import com.example.manageruniversity.mapper.TeacherMapper;
import com.example.manageruniversity.repository.auth.TokenRepository;
import com.example.manageruniversity.repository.auth.UserRepository;
import com.example.manageruniversity.service.IStudentService;
import com.example.manageruniversity.service.ITeacherService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final IStudentService studentService;
    private final ITeacherService teacherService;

    @Transactional
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = User.builder()
                .role(registerRequest.getRole())
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        User userSaved = userRepository.save(user);
        Object object = saveRoleStudentOrTeacher(registerRequest, userSaved.getId());
        String jwt = jwtService.generateToken(user);
        saveToken(userSaved, jwt);
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .person(object)
                .build();
    }

    private Object saveRoleStudentOrTeacher(RegisterRequest registerRequest,
                                            Long userId) {
        Object person = null;
        if (registerRequest.getRole().equals(Role.STUDENT)) {
            StudentDTO studentDTO = registerRequest.getStudentDTO();
            studentDTO.setUserId(userId);
            person = studentService.saveOrUpdate(studentDTO);
        } else if (registerRequest.getRole().equals(Role.TEACHER)) {
            TeacherDTO teacherDTO = registerRequest.getTeacherDTO();
            teacherDTO.setUserId(userId);
            person  = teacherService.saveOrUpdate(teacherDTO);
        }
        return person;
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
        var student = user.getStudent() != null ?
                StudentMapper.mapper.studentToDTO(user.getStudent())
                : null;
        var teacher = user.getTeacher() != null ?
                TeacherMapper.mapper.teacherToDTO(user.getTeacher())
                : null;
        var jwt = jwtService.generateToken(user);
        saveToken(user, jwt);
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .person(student == null ? teacher : student)
                .build();
    }

    public void logout(HttpServletRequest request) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        jwt = authHeader.substring(7);
        var storedToken = tokenRepository.findByToken(jwt).orElse(null);
        if(storedToken != null) {
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepository.save(storedToken);
            SecurityContextHolder.clearContext();
        }
    }
}

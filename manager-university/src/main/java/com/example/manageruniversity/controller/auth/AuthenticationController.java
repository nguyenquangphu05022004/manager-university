package com.example.manageruniversity.controller.auth;
import com.example.manageruniversity.dto.UserDTO;
import com.example.manageruniversity.dto.auth.AuthenticationRequest;
import com.example.manageruniversity.dto.auth.AuthenticationResponse;
import com.example.manageruniversity.dto.auth.RegisterRequest;
import com.example.manageruniversity.service.auth.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService authService;
    @PostMapping("/auth/register")
    public AuthenticationResponse register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }
    @PostMapping("/auth/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authRequest) {
        return authService.authenticate(authRequest);
    }
    @GetMapping("/auth/logout")
    public void logout(HttpServletRequest servletRequest) {
        authService.logout(servletRequest);
    }


    @PostMapping("/change-password")
    public void changePassword(@RequestParam("oldPass") String oldPass,
                               @RequestParam("newPass") String newPass) {
        authService.changePassword(oldPass, newPass);
    }

    @GetMapping("/user")
    public UserDTO getInfoUser() {
        return authService.getInfoUser(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}

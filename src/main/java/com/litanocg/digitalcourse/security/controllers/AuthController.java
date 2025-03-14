package com.litanocg.digitalcourse.security.controllers;

import com.litanocg.digitalcourse.security.dto.LoginRequest;
import com.litanocg.digitalcourse.security.dto.LoginResponse;
import com.litanocg.digitalcourse.security.model.UserPrincipal;
import com.litanocg.digitalcourse.security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private ReactiveAuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Mono<LoginResponse> login(@RequestBody LoginRequest request) {
        return authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()))
                .cast(UserPrincipal.class)
                .map(user -> new LoginResponse(jwtUtil.generateToken(user), user.getId()));
    }
}

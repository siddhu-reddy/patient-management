package com.pm.auth.services;

import com.pm.auth.dto.LoginRequestDTO;
import com.pm.auth.dto.LoginResponseDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    AuthService(AuthenticationManager authenticationManager,JwtService jwtService){
        this.authenticationManager=authenticationManager;
        this.jwtService=jwtService;
    }



}

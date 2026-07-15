package com.pm.auth.services;

import com.pm.auth.Repository.AuthRepository;
import com.pm.auth.dto.*;
import com.pm.auth.mapper.UsersMapping;
import com.pm.auth.model.Users;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServices {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    public AuthRepository authRepository;
    public JwtService jwtService;
    public UserServices(AuthRepository authRepository, AuthenticationManager authenticationManager, JwtService jwtService, PasswordEncoder passwordEncoder){
        this.authRepository=authRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService=jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO userCreate(UserRequestDTO userRequestDTO){
        Users user=UsersMapping.toModel(userRequestDTO);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        authRepository.save(user);
        return UsersMapping.toDTO(user);
    }

    public List<UserResponseDTO> getUsers(){
        return authRepository.findAll().stream().map(UsersMapping::toDTO).collect(Collectors.toList());
    }

    public LoginResponseDTO loginUser(LoginRequestDTO loginRequestDto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword()));
        String token = jwtService.generateToken(loginRequestDto.username);
        LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
        loginResponseDTO.setToken(token);
        return loginResponseDTO;
    }

    public void registerUser(UserRequestDTO requestDTO){
        if(authRepository.findByUsername(requestDTO.getUsername()).isPresent()){
            throw new RuntimeException("username already exist");
        }
        Users users=UsersMapping.toModel(requestDTO);
        users.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        authRepository.save(users);
        return;
    }
}

package com.pm.auth.services;

import com.pm.auth.Repository.AuthRepository;
import com.pm.auth.dto.UserRequestDTO;
import com.pm.auth.dto.UserResponseDTO;
import com.pm.auth.mapper.UsersMapping;
import com.pm.auth.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServices {
    public AuthRepository authRepository;
    public UserServices(AuthRepository authRepository){
        this.authRepository=authRepository;
    }

    public UserResponseDTO userCreate(UserRequestDTO userRequestDTO){
        Users user=authRepository.save(UsersMapping.toModel(userRequestDTO));
        return UsersMapping.toDTO(user);
    }

    public List<UserResponseDTO> getUsers(){
        return authRepository.findAll().stream().map(UsersMapping::toDTO).collect(Collectors.toList());
    }
}

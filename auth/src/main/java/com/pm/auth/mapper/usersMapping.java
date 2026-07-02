package com.pm.auth.mapper;

import com.pm.auth.dto.UserRequestDTO;
import com.pm.auth.dto.UserResponseDTO;
import com.pm.auth.model.Users;

public class UsersMapping {
    public static Users toModel(UserRequestDTO userRequestDTO) {
        Users user = new Users();
        user.setEmail(userRequestDTO.getEmail());
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(userRequestDTO.getPassword());
        return user;
    }
    public static UserResponseDTO toDTO(Users users){
        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.setId(users.getId().toString());
        userResponseDTO.setEmail(users.getEmail());
        userResponseDTO.setName(users.getUsername());
        return userResponseDTO;
    }
}

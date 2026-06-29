package com.pm.auth.mapper;

import com.pm.auth.dto.UserRequestDTO;
import com.pm.auth.model.Users;
import org.apache.catalina.User;

public class usersMapping {
    public static Users toModel(UserRequestDTO userRequestDTO) {
        Users user = new Users();
        user.setEmail(userRequestDTO.getEmail());
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(userRequestDTO.getPassword());
        return user;
    }
}

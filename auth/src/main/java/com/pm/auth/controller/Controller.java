package com.pm.auth.controller;

import com.pm.auth.dto.UserRequestDTO;
import com.pm.auth.dto.UserResponseDTO;
import com.pm.auth.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    final UserServices userServices;

    public Controller(UserServices userServices){
        this.userServices=userServices;
    }

    @GetMapping("/")
    public String greet(){
        return  "hello";
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getUsers(){
        return ResponseEntity.ok().body(userServices.getUsers());
    }

    @PostMapping("/")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
        System.out.println("controller");
        return ResponseEntity.ok().body(userServices.userCreate(userRequestDTO));
    }

}

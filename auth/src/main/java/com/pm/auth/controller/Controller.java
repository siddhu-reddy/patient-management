package com.pm.auth.controller;

import com.pm.auth.dto.UserRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/")
    public String greet(){
        return  "hello";
    }

    @PostMapping("/")
    public String createUser(@RequestBody UserRequestDTO userRequestDTO){

    }

}

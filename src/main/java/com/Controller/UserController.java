package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.DTO.LoginRequestDTO;
import com.DTO.LoginResponseDTO;
import com.DTO.UserRequestDTO;
import com.Entity.User;
import com.Service.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public String createUser( @Valid @RequestBody UserRequestDTO requestDTO) {

        return userService.createUser(requestDTO);
    }

   

    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }
    
    @PostMapping("/login")
    public LoginResponseDTO login( @Valid @RequestBody LoginRequestDTO requestDTO) {

        return userService.login(requestDTO);
    }
    	
    
}
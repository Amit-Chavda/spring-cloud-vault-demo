package com.example.springcloudvaultdemo.controller;

import com.example.springcloudvaultdemo.config.ClientCredentials;
import com.example.springcloudvaultdemo.dto.GenericResponse;
import com.example.springcloudvaultdemo.dto.UserDto;
import com.example.springcloudvaultdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final UserService userService;
    private final ClientCredentials clientCredentials;

    @GetMapping("/user")
    public ResponseEntity<GenericResponse> getUsers() {
        return ResponseEntity.ok(new GenericResponse(true, "Users returned successfully", userService.findAll(), HttpStatus.OK.value(), LocalDateTime.now()));
    }

    @PostMapping("/user")
    public ResponseEntity<GenericResponse> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(new GenericResponse(true, "User saved successfully", userService.add(userDto), HttpStatus.CREATED.value(), LocalDateTime.now()));
    }


    @GetMapping("/clientCredentials")
    public ResponseEntity<GenericResponse> getClientCredentials() {
        return ResponseEntity.ok(new GenericResponse(true, "Users returned successfully", clientCredentials, HttpStatus.OK.value(), LocalDateTime.now()));
    }
}

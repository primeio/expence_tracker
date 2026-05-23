package com.fullstack.BackenExT.controller;

import com.fullstack.BackenExT.dto.AuthDto;
import com.fullstack.BackenExT.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody AuthDto authDto){
        return new ResponseEntity<>(userService.register(authDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?>  login(@Valid @RequestBody AuthDto authDto){
        return new ResponseEntity<>(userService.Login(authDto), HttpStatus.CREATED);
    }
}

package com.fullstack.BackenExT.service;

import com.fullstack.BackenExT.config.JwtUtil;
import com.fullstack.BackenExT.dto.AuthDto;
import com.fullstack.BackenExT.dto.LoginResponse;
import com.fullstack.BackenExT.dto.RegisterResponse;
import com.fullstack.BackenExT.model.User;
import com.fullstack.BackenExT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public RegisterResponse register(AuthDto authDto) {

        RegisterResponse registerResponse = new RegisterResponse();

        if (userRepository.existsByUsername(authDto.getUsername())) {
            registerResponse.setMessage("Username already exists");
            return registerResponse;
        }
        User user = User.builder()
                .username(authDto.getUsername())
                .password(passwordEncoder.encode(authDto.getPassword()))
                .role(User.Role.USER)
                .build();
        userRepository.save(user);


        registerResponse.setMessage("Registration successful");
        return registerResponse;
    }

    public LoginResponse Login(AuthDto authDto) {

        LoginResponse loginResponse = new LoginResponse();
        Authentication authentication = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword()));

        if (authentication.isAuthenticated()){
               loginResponse.setToken( jwtUtil.generateToken(authDto.getUsername()));
             loginResponse.setMessage("login successful.");
             return loginResponse;
        }

        loginResponse.setMessage("login failed");

        return loginResponse;
    }

}

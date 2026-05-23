package com.fullstack.BackenExT.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthDto {
    @NotBlank(message = "username required")
    private String username;

    @NotBlank(message = "password required")
    private String password;
}

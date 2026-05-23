package com.fullstack.BackenExT.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDto {
    @NotBlank
    private String name;
}

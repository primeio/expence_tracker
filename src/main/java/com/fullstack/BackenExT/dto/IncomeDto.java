package com.fullstack.BackenExT.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class IncomeDto {

    @NotNull(message = "Invalid income amount.")
    private BigDecimal amount;

    @NotNull(message = "Invalid date")
    private LocalDate incomeDate;

    @NotBlank(message = "Source required.")
    private String source;
}

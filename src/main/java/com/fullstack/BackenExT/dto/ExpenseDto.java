package com.fullstack.BackenExT.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseDto {

    @NotNull(message = "Invalid expense amount")
    private BigDecimal amount;

    @NotNull( message = "Invalid category ")
    private Long categoryId;

    @NotNull(message = "Invalid expense date")
    private LocalDate expenseDate;

    private String note;
}

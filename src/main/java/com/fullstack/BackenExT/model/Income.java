package com.fullstack.BackenExT.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "incomes")
@Builder
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    private String source;

    @Column(nullable = false)
    private LocalDate incomeDate;
}

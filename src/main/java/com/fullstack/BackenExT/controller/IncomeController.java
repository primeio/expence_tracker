package com.fullstack.BackenExT.controller;

import com.fullstack.BackenExT.dto.IncomeDto;
import com.fullstack.BackenExT.model.Income;
import com.fullstack.BackenExT.service.IncomeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
@AllArgsConstructor

public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping("/all")
    public List<Income> getAllIncome() {

        return incomeService.getAllIncome();
    }

    @GetMapping("/{id}")
    public Income getIncome(@PathVariable Long id) {

        return incomeService.getIncome(id);
    }

    @PostMapping("/create")
    public Income createIncome(
            @RequestBody IncomeDto incomeDto) {

        return incomeService.addIncome(incomeDto);
    }

    @PutMapping("/update/{id}")
    public Income updateIncome(
            @PathVariable Long id,
            @RequestBody IncomeDto incomeDto) {

        return incomeService.updateIncome(id, incomeDto);
    }

    @DeleteMapping("/{id}")
    public String deleteIncome(@PathVariable Long id) {

        incomeService.deleteIncome(id);

        return "Income deleted successfully";
    }
}
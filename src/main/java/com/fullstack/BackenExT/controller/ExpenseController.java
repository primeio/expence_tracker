package com.fullstack.BackenExT.controller;

import com.fullstack.BackenExT.dto.ExpenseDto;
import com.fullstack.BackenExT.model.Expense;
import com.fullstack.BackenExT.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@AllArgsConstructor

public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping("/all")
    public List<Expense> getAllExpenses() {

        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpense(@PathVariable Long id) {

        return expenseService.getExpense(id);
    }

    @PostMapping("/create")
    public Expense createExpense(
            @RequestBody ExpenseDto expenseDto) {

        return expenseService.addExpense(expenseDto);
    }

    @PutMapping("/update/{id}")
    public Expense updateExpense(
            @PathVariable Long id,
            @RequestBody ExpenseDto expenseDto) {

        return expenseService.updateExpense(id, expenseDto);
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {

        expenseService.deleteExpense(id);

        return "Expense deleted successfully";
    }
}
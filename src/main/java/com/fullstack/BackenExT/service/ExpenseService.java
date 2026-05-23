package com.fullstack.BackenExT.service;

import com.fullstack.BackenExT.dto.ExpenseDto;
import com.fullstack.BackenExT.model.Category;
import com.fullstack.BackenExT.model.Expense;
import com.fullstack.BackenExT.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final CategoryService categoryService;

    public Expense getExpense(Long id){
        return expenseRepository.findById(id).orElseThrow(()->
                new RuntimeException("Expense not found with id :"+id));
    }
    public Expense addExpense(ExpenseDto expenseReq){

        Category category = categoryService
                .getCategory(expenseReq.getCategoryId());

        Expense expense = new Expense();

        expense.setExpenseDate(expenseReq.getExpenseDate());
        expense.setCategory(category);
        expense.setNote(expenseReq.getNote());
        expense.setAmount(expenseReq.getAmount());

        return expenseRepository.save(expense);
    }
    public Expense updateExpense(Long id, ExpenseDto expenseReq){

        Category category = categoryService
                .getCategory(expenseReq.getCategoryId());

        Expense expense = getExpense(id);

        expense.setAmount(expenseReq.getAmount());
        expense.setNote(expenseReq.getNote());
        expense.setExpenseDate(expenseReq.getExpenseDate());
        expense.setCategory(category);

        return expenseRepository.save(expense);
    }
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }
    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }
}

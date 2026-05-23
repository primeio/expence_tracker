package com.fullstack.BackenExT.service;

import com.fullstack.BackenExT.dto.IncomeDto;
import com.fullstack.BackenExT.model.Income;
import com.fullstack.BackenExT.repository.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IncomeService {
    private final IncomeRepository incomeRepository;

    public Income getIncome(Long id){
        return incomeRepository.findById(id).orElseThrow(()->
                new RuntimeException("Income not found with id:"+id));
    }
    public List<Income> getAllIncome(){
        return incomeRepository.findAll();
    }
    public Income addIncome(IncomeDto incomeReq){
        Income income = new Income();

        income.setIncomeDate(incomeReq.getIncomeDate());
        income.setAmount(incomeReq.getAmount());
        income.setSource(incomeReq.getSource());
        return incomeRepository.save(income);
    }
    public Income updateIncome(Long id, IncomeDto incomeReq){
        Income income = getIncome(id);
        income.setIncomeDate(incomeReq.getIncomeDate());
        income.setSource(incomeReq.getSource());
        income.setAmount(incomeReq.getAmount());
        return incomeRepository.save(income);
    }
    public void deleteIncome(Long id){
        incomeRepository.deleteById(id);
    }
}

package com.aaronhuang.expensetracker.service;
import java.util.List;
import java.util.Optional;
import com.aaronhuang.expensetracker.model.Income;

public interface IncomeService {
    Income create(Income income, String authHeader);
    Optional<Income> getById(Long id, String authHeader);
    List<Income> getAll(String authHeader);
    Income updateById(Long id, Income income, String authHeader);
    Income deleteById(Long id, String authHeader);

}
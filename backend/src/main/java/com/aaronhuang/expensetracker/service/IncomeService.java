package com.aaronhuang.expensetracker.service;
import java.util.List;
import java.util.Optional;
import com.aaronhuang.expensetracker.model.Income;

public interface IncomeService {
    Income create(Income income);
    Optional<Income> getById(Long id);
    List<Income> getAll();
    Income updateById(Long id, Income income);
    Income deleteById(Long id);

}
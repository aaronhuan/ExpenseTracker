package com.aaronhuang.expensetracker.service;
import java.util.List;
import java.util.Optional;

import com.aaronhuang.expensetracker.model.Expense;


public interface ExpenseService {
    Expense create(Expense e);
    Optional<Expense> getById(Long id);
    List<Expense> getAll();
    Expense updateById(Long id, Expense e);
    Expense deleteById(Long id);
}

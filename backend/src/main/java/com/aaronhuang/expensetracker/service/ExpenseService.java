package com.aaronhuang.expensetracker.service;
import java.util.List;
import java.util.Optional;

import com.aaronhuang.expensetracker.model.Expense;


public interface ExpenseService {
    Expense create(Expense e, String authHeader);
    Optional<Expense> getById(Long id, String authHeader);
    List<Expense> getAll(String authHeader);
    Expense updateById(Long id, Expense e, String authHeader);
    Expense deleteById(Long id, String authHeader);
}
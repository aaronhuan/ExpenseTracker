package com.aaronhuang.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaronhuang.expensetracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
}

package com.aaronhuang.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaronhuang.expensetracker.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    
}

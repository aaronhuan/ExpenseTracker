package com.aaronhuang.expensetracker.service;
import org.springframework.stereotype.Service;

import com.aaronhuang.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepo;
}

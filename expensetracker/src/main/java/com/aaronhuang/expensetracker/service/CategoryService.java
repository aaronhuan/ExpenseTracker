package com.aaronhuang.expensetracker.service;
import org.springframework.stereotype.Service;

import com.aaronhuang.expensetracker.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository category;
    public CategoryService(CategoryRepository category){
        this.category=category;
    }
}

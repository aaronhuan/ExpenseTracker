package com.aaronhuang.expensetracker.service;
import java.util.List;
import java.util.Optional;


import com.aaronhuang.expensetracker.model.Category;

public interface CategoryService{
    Category create(Category c);
    Optional<Category> getById(Long id);
    List<Category> getAll();
    Category updateById(Long id, Category c);
    Category deleteById(Long id);
}

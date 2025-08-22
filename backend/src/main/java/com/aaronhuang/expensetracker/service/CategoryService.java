package com.aaronhuang.expensetracker.service;
import java.util.List;
import java.util.Optional;


import com.aaronhuang.expensetracker.model.Category;

public interface CategoryService{
    Category create(Category c, String authHeader);
    Optional<Category> getById(Long id, String authHeader);
    List<Category> getAll(String authHeader);
    Category updateById(Long id, Category c, String authHeader);
    Category deleteById(Long id, String authHeader);
}
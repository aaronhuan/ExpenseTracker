package com.aaronhuang.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aaronhuang.expensetracker.model.Category;
import com.aaronhuang.expensetracker.repository.CategoryRepository;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repo; 

    public CategoryServiceImpl(CategoryRepository repo){
        this.repo=repo;
    }

    @Override 
    public Category create(Category c){
        return repo.save(c);
    }

    @Override
    public Optional<Category> getById(Long id){
        return repo.findById(id);
    }

    @Override 
    public List<Category> getAll(){
        return repo.findAll();
    }

    @Override
    public Category updateById(Long id, Category c){
        Category existing = getById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                                                            "Category not found: " + id));
        existing.setName(c.getName());
        return repo.save(existing);
    }
    
    @Override
    public Category deleteById(Long id){
        Category existing = getById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                                                            "Category not found: " + id));
        repo.delete(existing);
        return existing;
    }
}
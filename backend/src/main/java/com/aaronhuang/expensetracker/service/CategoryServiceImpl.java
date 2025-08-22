package com.aaronhuang.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aaronhuang.expensetracker.model.Category;
import com.aaronhuang.expensetracker.model.User;
import com.aaronhuang.expensetracker.repository.CategoryRepository;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repo; 
    private final UserServiceImpl userService;
    public CategoryServiceImpl(CategoryRepository repo, UserServiceImpl userService){
        this.repo=repo;
        this.userService = userService;
    }

    @Override 
    public Category create(Category c, String authHeader){
        User user = userService.getUserFromToken(authHeader);
        c.setUser(user);
        return repo.save(c);
    }

    @Override
    public Optional<Category> getById(Long id, String authHeader){
        User user = userService.getUserFromToken(authHeader);
        return repo.findByIdAndUser(id, user);
    }

    @Override 
    public List<Category> getAll(String authHeader){
        User user = userService.getUserFromToken(authHeader);
        return repo.findByUser(user);
    }

    @Override
    public Category updateById(Long id, Category c, String authHeader){
        Category existing = repo.findByIdAndUser(id, userService.getUserFromToken(authHeader))
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                                                            "Category not found: " + id));
        existing.setName(c.getName());
        return repo.save(existing);
    }
    
    @Override
    public Category deleteById(Long id, String authHeader){
        Category existing = repo.findByIdAndUser(id, userService.getUserFromToken(authHeader))
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                                                            "Category not found: " + id));
        repo.delete(existing);
        return existing;
    }
}
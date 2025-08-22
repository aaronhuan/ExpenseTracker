package com.aaronhuang.expensetracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaronhuang.expensetracker.model.Category;
import com.aaronhuang.expensetracker.service.CategoryService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService cSvc ;

    public CategoryController(CategoryService cSvc){
        this.cSvc = cSvc;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id, @RequestHeader("Authorization") String authHeader) {
        Optional <Category> category = cSvc.getById(id, authHeader);
        return ResponseEntity.of(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(@RequestHeader("Authorization") String authHeader) {
        List<Category> lCategories = cSvc.getAll(authHeader);
        return ResponseEntity.ok(lCategories);
    }
    
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category, @RequestHeader("Authorization") String authHeader) {        
        Category created = cSvc.create(category, authHeader);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category, @RequestHeader("Authorization") String authHeader) {
        Category updated = cSvc.updateById(id, category, authHeader);    
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id, @RequestHeader("Authorization") String authHeader){
        Category deleted= cSvc.deleteById(id, authHeader);
        return ResponseEntity.ok(deleted);
    }

}
package com.aaronhuang.expensetracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aaronhuang.expensetracker.model.Expense;
import com.aaronhuang.expensetracker.service.ExpenseService;


@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {
    private final ExpenseService eSvc;
    public ExpenseController(ExpenseService eSvc){
        this.eSvc = eSvc;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){
        Optional <Expense> expense = eSvc.getById(id);
        return ResponseEntity.of(expense); 
    }


    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return ResponseEntity.ok(eSvc.getAll());
    }

    @PutMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense e){
        Expense created = eSvc.create(e);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id,@RequestBody Expense e){
        Expense updated = eSvc.updateById(id, e);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Expense> deleteExpense(@PathVariable Long id){
        Expense deleted= eSvc.deleteById(id);
        return ResponseEntity.ok(deleted);
    }

}
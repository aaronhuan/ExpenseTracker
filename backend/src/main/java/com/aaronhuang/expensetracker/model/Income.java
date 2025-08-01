package com.aaronhuang.expensetracker.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.Min;  
import jakarta.persistence.*;
@Entity
@Table(name="incomes")
public class Income {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String source;
    
    @Column(nullable=false, updatable=false)
    private LocalDateTime date;

    @Min(value = 0, message = "Amount must be a positive number")
    @Column(nullable = false)
    private BigDecimal amount;
    
    @Column(nullable = false)
    private Boolean reoccuring=false; 

    @Column(nullable = false)
    private String frequency="One Time"; // e.g., monthly, weekly, etc.
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="user_id")
    private User user;

    public Income() {} // JPA needs a no-arg constructor to build the object

    public Income(String source, BigDecimal amount, User user, Boolean reoccuring, String frequency) {
        this.source = source;
        this.amount = amount;
        this.user = user;
        this.reoccuring=reoccuring;
        this.frequency = frequency;
        this.date = LocalDateTime.now(); // auto-set timestamp
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user){
        this.user=user;
    }

    
    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Boolean getReoccuring() {
        return reoccuring;
    }
    
    public void setReoccuring(Boolean reoccuring) {
        this.reoccuring = reoccuring;
    }
}

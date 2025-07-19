package com.aaronhuang.expensetracker.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name="expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(nullable=false, updatable=false)
    private LocalDateTime date;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="user_id")
    private User user; // can be many to one from users to expenses

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="category_id")//creates a Join column for Category.Id
    private Category category;

    @Column(nullable=false)
    private String description="";

    @Column(nullable=false)
    private BigDecimal amount= BigDecimal.ZERO;

    private String currency="USD";

    public Expense(){}

    public Expense(User user, Category category, String description, BigDecimal amount){
        this.user=user;
        this.category=category;
        this.description=description;
        this.amount=amount;
    }

    @PrePersist
    private void onCreate(){
        this.date = LocalDateTime.now();
    }

    //getter and setters
    public Long getId(){
        return id;
    }
    //no setId, automated

    public LocalDateTime getDate(){
        return date;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category=category;
    }
    
    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public void setAmount(BigDecimal amount){
        this.amount=amount;
    }

    public String getCurrency(){
        return currency;
    }

    public void setCurrency(String currency){
        this.currency=currency;
    }

    public String toString(){
        return String.format("Expense[%s: %s %s %s]",
            id, date, amount.toPlainString(), description);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true; // compare the reference in memory
        if(!(o instanceof Expense)) return false; //find out if the class is the same
        Expense that = (Expense) o; //cast it from o to expense
        if(id != null && that.getId() !=null){//check for null in primary key (id)
            return id.equals(that.getId()); //compare id
        }
        return Objects.equals(date, that.getDate()) && 
            Objects.equals(amount,that.getAmount()) &&
            Objects.equals(user!= null ? user.getId():null, that.user!=null? that.user.getId(): null) &&
            Objects.equals(category!=null ? category.getId():null, that.category!=null ? that.category.getId(): null)&&
            Objects.equals(currency != null ? currency : null, that.currency != null ? that.getCurrency() : null) &&
            Objects.equals(description, that.getDescription());
            //else compare all fields
    }

    @Override 
    public int hashCode(){
        return (id != null 
        ? id.hashCode()
        : Objects.hash(date, amount, currency, description,
        user != null ? user.getId():null,
         category != null ? category.getId():null));
    }
}





















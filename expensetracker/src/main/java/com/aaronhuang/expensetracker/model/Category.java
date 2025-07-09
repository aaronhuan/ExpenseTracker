package com.aaronhuang.expensetracker.model;

import jakarta.persistence.*;

@Entity
@Table(name="categories",
uniqueConstraints= @UniqueConstraint(columnNames= "name"))//prevent dupe names 
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private boolean builtIn; // true for built in values, false for user created 

    public Category(){} // JPA needs a no-arg constructor to build the object

    public Category(String name, boolean builtIn){
        this.name=name;
        this.builtIn=builtIn;
    }

    //getter and setters 
    public Long getId(){
        return id;
    }
    //no setId, automated
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
    // no set category, this is built in categories

    public boolean isBuiltIn(){
        return builtIn;
    }

    // no setBuiltIn(): decided at creation

    @Override
    public String toString(){
        return String.format("Category[%d:%s (%s)]", id, name, builtIn ? "built-in" : "custom");
    }

}

package com.aaronhuang.expensetracker.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "categories",
    uniqueConstraints = @UniqueConstraint(columnNames = {"name", "user_id"})// unique per user
)
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private boolean builtIn; // true for built in values, false for user created 

    public Category(){} // JPA needs a no-arg constructor to build the object

    public Category(String name, boolean builtIn, User user){
        this.name=name;
        this.builtIn=builtIn;
        this.user=user;
    }

    //getter and setters 
    public Long getId(){
        return id;
    }
    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }

    //no setId, automated
    public String getName(){
        return name;
    }

    public void setName(String name){
        if(!this.builtIn){// Only allow updates for user-created categories
            this.name=name;
        }

    }
    // no set category, this is built in categories

    public boolean isBuiltIn(){
        return builtIn;
    }

    // no setBuiltIn(): decided at creation

    @Override
    public String toString(){
        return String.format("Category[%s:%s (%s)]", id, name, builtIn);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true; // compare the reference in memory
        if(!(o instanceof Category)) return false; //find out if the class is the same
        Category that = (Category) o; //cast it from o to category
        if(id != null && that.getId() !=null){//check for null in primary key (id)
            return id.equals(that.getId()); //compare id
        }
        return name.equals(that.name);//else compare name, since name is unique to each category
    }

    @Override 
    public int hashCode(){
        return (id != null ? id.hashCode(): name.hashCode());
    }

}
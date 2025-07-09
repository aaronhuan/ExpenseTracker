package com.aaronhuang.expensetracker.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="users",
uniqueConstraints = @UniqueConstraint(columnNames= "email")) //prevent dupe emails
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false, updatable=false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private String password;
    //password add hash and salt later  

    public User(){}
    
    public User(String name, String email, String password){
        this.name= name;
        this.email=email;
        this.password=password;
    }

    // @PrePersist =method should be called before the entity is inserted (persisted) into the database.
    @PrePersist
    private void onCreate(){
        this.createdAt=LocalDateTime.now(); // auto-set timestamp
    }


    //getters and setters
    public Long getId(){
        return id;
    }

    // no set id because its auto generated 

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }


    @Override
    public String toString(){
        return String.format("User[%d:%s <%s>]", id,name,email);
    }
}

package com.BrushCircle.model;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

//@Data
//@Entity
public class User {
//
//    private @Id
//    @GeneratedValue
//    Long id;
//    private String firstName;
//    private String lastName;
//    private String description;
//
//    private @Version
//    @JsonIgnore
//    Long version;
//
//    private @ManyToOne
//    Admin admin;
//
//    private User() {}
//
//    public User(String firstName, String lastName, String description, Admin admin) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.description = description;
//        this.admin = admin;
//    }
}
package com.BrushCircle.payload.user;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String state;
    private String patreon;
    private String cashapp;
    private String title;
    private String biography;
    private List<Product> products;
    private String role;
}

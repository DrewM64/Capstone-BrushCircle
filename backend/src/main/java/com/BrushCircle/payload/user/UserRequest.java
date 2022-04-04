package com.BrushCircle.payload.user;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
public class UserRequest {

    private Long id;

    @NotBlank(message = "First name cannot be empty")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Password cannot be empty")
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

package com.BrushCircle.dto;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;

import java.util.List;

public class UserDTO {

    private User user;
    private List<Product> products;

    public UserDTO() {
    }

    public UserDTO(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user=" + user +
                ", products=" + products +
                '}';
    }
}

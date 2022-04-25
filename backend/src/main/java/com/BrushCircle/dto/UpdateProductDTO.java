package com.BrushCircle.dto;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;

import java.util.List;

public class UpdateProductDTO {
    private User user;
    private Product product;

    public UpdateProductDTO() {
    }

    public UpdateProductDTO(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product products) {
        this.product = products;
    }
}

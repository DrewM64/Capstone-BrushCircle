package com.BrushCircle.payload.product;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import lombok.Data;

import java.util.List;

@Data
public class ProductSearchRequest {
    private List<User> users;
    private List<Product> products;
    private List<String> styles;
}

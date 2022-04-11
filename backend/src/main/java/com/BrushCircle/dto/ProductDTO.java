package com.BrushCircle.dto;

import com.BrushCircle.model.Product;

import java.util.List;

public class ProductDTO {

    private List<String> styles;
    private List<Product> products;

    public ProductDTO() {
    }

    public ProductDTO(List<String> styles, List<Product> products) {
        this.styles = styles;
        this.products = products;
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

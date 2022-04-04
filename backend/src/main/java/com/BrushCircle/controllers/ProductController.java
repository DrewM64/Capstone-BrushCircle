package com.BrushCircle.controllers;

import com.BrushCircle.mapper.ProductMapper;
import com.BrushCircle.model.Product;
import com.BrushCircle.repository.ProductRepository;
import com.BrushCircle.service.graphql.GraphQLProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    private final ProductMapper productMapper;
    private final GraphQLProvider graphQLProvider;

    @PostMapping("/upload")
    public String uploadNewProduct() {
        return "uploadNewProduct was called";
    }

    @PostMapping("/get")
    public Iterable<Product> getCars() {
        return productRepository.findAll();
    }

    @PostMapping("/update")
    public String updateProduct() {
        return "updateProduct was called";
    }

    @PostMapping("/delete")
    public String deleteProduct() {
        return "deleteProduct was called";
    }
}

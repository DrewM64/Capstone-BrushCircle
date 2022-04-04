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
@RequestMapping("/search")
public class SearchController {
    private final ProductMapper productMapper;
    private final GraphQLProvider graphQLProvider;

    @GetMapping("/search")
    public String search() {
        return "search was called";
    }
}

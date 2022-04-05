package com.BrushCircle.repository;

import java.util.List;

import com.BrushCircle.service.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository <Product, Long> {
    // Fetch product by style
    List<Product> findByProductStyle(@Param("productStyle") String productStyle);

    // Fetch product by title
    List<Product> findByProductTitle(@Param("productTitle") String productTitle);
}

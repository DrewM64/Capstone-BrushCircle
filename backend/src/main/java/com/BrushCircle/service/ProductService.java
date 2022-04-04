package com.BrushCircle.service;

import com.BrushCircle.model.Product;

import graphql.schema.DataFetcher;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    DataFetcher<Product> getProductByQuery();

    DataFetcher<List<Product>> getAllProductsByQuery();

    DataFetcher<List<Product>> getAllProductsByIdsQuery();

    List<Product> findProductsByIds(Long userId);

    Product findProductById(Long productId);

    List<Product> findAllProducts();

    List<Product> findProductsByIds(List<Long> productsId);



    List<Product> filter(List<String> products, List<String> genders, List<Integer> prices, boolean sortByPrice);

    List<Product> findByProductOrderByPriceDesc(String product);

    List<Product> findByProductGenderOrderByPriceDesc(String productGender);

    Product saveProduct(Product product, MultipartFile file);

    List<Product> deleteProduct(Long productId);
}

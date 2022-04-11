package com.BrushCircle.service;

import com.BrushCircle.model.Product;
//import com.BrushCircle.service.model.Product;

//import graphql.schema.DataFetcher;
import com.BrushCircle.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    Product registerProduct(Product newProduct, MultipartFile file) throws Exception;

    Product getProductInfo(Product product) throws Exception;

    Product update(User currentUser, Product currentProduct) throws Exception;

    List<Product> delete(User currentUser, Product currentProduct) throws Exception;

    List<Product> getProductList(User currentUser) throws Exception;

    List<String> removeStyleDuplicates(String[] styleList) throws Exception;
}

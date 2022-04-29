package com.BrushCircle.service;

import com.BrushCircle.dto.UpdateProductDTO;
import com.BrushCircle.dto.UserDTO;
import com.BrushCircle.model.Product;
//import com.BrushCircle.service.model.Product;

//import graphql.schema.DataFetcher;
import com.BrushCircle.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> registerProduct(User user, MultipartFile file) throws Exception;

    Product getProductInfo(Product product) throws Exception;

    Product update(UpdateProductDTO updateProductDTO) throws Exception;

    UserDTO delete(UpdateProductDTO updateProductDTO) throws Exception;

    List<Product> getProductList(User currentUser) throws Exception;

    List<String> removeStyleDuplicates(List<String> styleList) throws Exception;

    String getFileNameNoExtension(String fileName);

    void getLogs(User user, MultipartFile file, Product product);
}

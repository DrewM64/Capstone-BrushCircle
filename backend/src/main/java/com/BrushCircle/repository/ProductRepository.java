package com.BrushCircle.repository;

import java.util.ArrayList;
import java.util.List;

import com.BrushCircle.model.Product;
//import com.BrushCircle.service.model.Product;
import com.BrushCircle.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.multipart.MultipartFile;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository <Product, Long>, JpaSpecificationExecutor<Product> {
    // Fetch product by style
    List<Product> findByStyle(@Param("style") String style);

    // Fetch product by title
    Product findByTitle(@Param("title") String title);

    Product findByFilename(@Param("filename") String filename);

    //    DataFetcher<Product> getProductByQuery();
//
//    DataFetcher<List<Product>> getAllProductsByQuery();
//
//    DataFetcher<List<Product>> getAllProductsByIdsQuery();

//    Product findProductById(Long productId);

//    List<Product> findAllProducts();

//    List<Product> findProductsByIds(List<Long> productsId);
//
//    List<Product> filter(List<String> products, List<String> genders, List<Integer> prices, boolean sortByPrice);

//    Product saveProduct(Product product, MultipartFile file);

//    List<Product> deleteProduct(Long productId);

    List<Product> findByUser(@Param("user") User user);

//    @Query("SELECT * FROM product")
//    List<Product> findAllProducts();

//    @Query("SELECT style FROM product")
//    ArrayList<String> getStyles();
}

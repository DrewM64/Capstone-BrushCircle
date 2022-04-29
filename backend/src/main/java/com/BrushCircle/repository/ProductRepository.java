package com.BrushCircle.repository;

import java.util.List;
import java.util.Optional;

import com.BrushCircle.model.Product;
//import com.BrushCircle.service.model.Product;
import com.BrushCircle.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository <Product, Long>, JpaSpecificationExecutor<Product> {
    // Fetch product by style
    List<Product> findByStyle(@Param("style") String style);

    // Fetch product by title
    Product findByTitle(@Param("title") String title);

    Optional<Product> findById(@Param("id") Long id);

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
//    List<Product> filter(List<String> products, List<String> genders, List<float> prices, boolean sortByPrice);

//    Product saveProduct(Product product, MultipartFile file);

//    List<Product> deleteProduct(Long productId);

    List<Product> findByUser(@Param("user") User user);

    @Query("select case when count(p)> 0 then true else false end from Product p where lower(p.title) like lower(:title)")
    boolean existsByTitle(@Param("title") String title);

//    @Query("SELECT * FROM product")
//    List<Product> findAllProducts();

    @Query(value = "SELECT style FROM product", nativeQuery = true)
    List<String> getStyles();
}

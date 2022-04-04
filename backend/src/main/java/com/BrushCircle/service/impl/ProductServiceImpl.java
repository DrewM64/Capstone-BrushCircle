package com.BrushCircle.service.impl;

import com.BrushCircle.model.Product;
import com.BrushCircle.repository.ProductRepository;
import com.BrushCircle.service.ProductService;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import graphql.schema.DataFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//@Service
//@RequiredArgsConstructor
//public class ProductServiceImpl implements ProductService {
//
//    private final ProductRepository productRepository;
//    private final AmazonS3 amazonS3client;
//
//    @Value("${amazon.s3.bucket.name}")
//    private String bucketName;
//
//    @Override
//    public DataFetcher<Product> getProductByQuery() {
//        return dataFetchingEnvironment -> {
//            Long productId = Long.parseLong(dataFetchingEnvironment.getArgument("id"));
//            return productRepository.findById(productId).get();
//        };
//    }
//
//    @Override
//    public DataFetcher<List<Product>> getAllProductsByQuery() {
//        return dataFetchingEnvironment -> productRepository.findAllByOrderByIdAsc();
//    }
//
//    @Override
//    public Product findProductById(Long productId) {
//        return productRepository.findById(productId).get();
//    }
//
//    @Override
//    public List<Product> findAllProducts() {
//        return productRepository.findAllByOrderByIdAsc();
//    }
//
//    @Override
//    public List<Product> findProductsByIds(List<Long> productsId) {
//        return productRepository.findByIdIn(productsId);
//    }
//
//
//    @Override
//    public List<Product> findByProductrOrderByPriceDesc(String productr) {
//        return productRepository.findByProductrOrderByPriceDesc(productr);
//    }
//
//    @Override
//    public Product saveProduct(Product product, MultipartFile multipartFile) {
//        if (multipartFile == null) {
//            product.setFilename(amazonS3client.getUrl(bucketName, "empty.jpg").toString());
//        } else {
//            File file = new File(multipartFile.getOriginalFilename());
//            try (FileOutputStream fos = new FileOutputStream(file)) {
//                fos.write(multipartFile.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            String fileName = UUID.randomUUID().toString() + "." + multipartFile.getOriginalFilename();
//            amazonS3client.putObject(new PutObjectRequest(bucketName, fileName, file));
//            product.setFilename(amazonS3client.getUrl(bucketName, fileName).toString());
//            file.delete();
//        }
//        return productRepository.save(product);
//    }
//
//    @Override
//    @Transactional
//    public List<Product> deleteProduct(Long productId) {
//        Product product = productRepository.findById(productId).get();
//        productRepository.delete(product);
//        return productRepository.findAllByOrderByIdAsc();
//    }
//}

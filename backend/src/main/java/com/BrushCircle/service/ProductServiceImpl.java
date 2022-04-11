package com.BrushCircle.service;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import com.BrushCircle.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product registerProduct(Product newProduct, MultipartFile file) throws Exception {
        log.info("Running RegisterProduct");
        productRepository.save(newProduct);
        Product registeredProduct = productRepository.saveProduct(newProduct, file);
        try {
            if (newProduct == null) {
                throw new Exception();
            } else {
                return registeredProduct;
            }
        } catch (Exception e) {
            log.info("\n[Error Found] Product Title was not found..."
                    + "\n Email Expected:   " + newProduct.getTitle());
        }
        return null;
    }

    public Product getProductInfo(Product product) throws Exception {
        log.info("Getting Product Info");
        Product existing = productRepository.findByProductTitle(product.getTitle());
        return existing;
    }

    public Product update(User user, Product product) throws Exception {
        log.info("Updating Current Product Info");
        Product existing = productRepository.findByProductTitle(product.getTitle());
        boolean ifAdmin = false;
        try {
            if (user.getRole().equals("ADMIN")) {
                ifAdmin = true;
            }
            if ((existing.getUser() != user || ifAdmin == false)) {
                throw new Exception();
            }
            copyNonNullProperties(product, existing);
            productRepository.save(existing);
            return existing;
        } catch (Exception e) {
            log.info("\n[Error Found] User from Product(s) does not match..."
                    + "\n User Expected:    " + user.toString()
                    + "\n User Provided:    " + product.getUser().toString()
                    + "\n User Returned:    " + existing.getUser().toString());
        }
        return null;
    }

    public List<Product> delete(User user, Product product) throws Exception {
        log.info("Updating Current Product Info");
        Product existing = productRepository.findByProductTitle(product.getTitle());
        try {
            if (existing.getUser() != user) {
                throw new Exception();
            }
            copyNonNullProperties(product, existing);
            productRepository.deleteById(existing.getId());
            return user.getProducts();
        } catch (Exception e) {
            log.info("\n[Error Found] User from Product(s) does not match..."
                    + "\n User Expected:    " + user.toString()
                    + "\n User Provided:    " + product.getUser().toString()
                    + "\n User Returned:    " + existing.getUser().toString());
        }
        return null;
    }

    public List<Product> getProductList(User user) throws Exception {
        log.info("Updating Current Product Info");
        List<Product> existingList = productRepository.findByUser(user);
        try {
            if (existingList == null) {
                throw new Exception();
            }
            return existingList;
        } catch (Exception e) {
            log.info("\n[Error Found] User does not match..."
                    + "\n User Expected:    " + user.toString());
        }
        return null;
    }

    @Override
    public List<String> removeStyleDuplicates(String[] styleList) throws Exception {
        int i, j;
        int k = 0;
        boolean t = false;
    
        for (i = 0; i < styleList.length; i++) {
            for (j = 0; j < styleList.length; j++) {
                if((styleList[i].equals(styleList[j]))&&(j>i)){
                    t=true;
                }
            }
            if(t){
                k++;
            }
        }
        String[] styleList1 = new String[k];
        for (i = 0; i < styleList.length; i++) {
            for (j = 0; j < styleList.length; j++) {
                if(!(styleList[i].equals(styleList[j]))&&(j>i)){
                    t=true;
                }
            }
            if(t){
                styleList1[i]=styleList[i];
                t = false;
            }
        }
        try {
            if (styleList1 == null) {
                throw new Exception();
            }
            return List.of(styleList1);
        } catch (Exception e) {
            log.info("\n[Error Found] Styles Not Found..."
                    + "\n Styles Expected:  " + styleList
                    + "\n Styles Found:     " + styleList1);
        }
        return null;
    }

//    public static String[] removeDuplicates(String arr[], String n)
//    {
//        // Return, if array is empty
//        // or contains a single element
//        if (n == null) {
//            return n;
//        }
//
//        int[] temp = new int[n];
//
//        // Start traversing elements
//        String j = 0;
//        for (int i=0; i<n-1; i++)
//            // If current element is not equal
//            // to next element then store that
//            // current element
//            if (arr[i] != arr[i+1])
//                temp[j++] = arr[i];
//
//        // Store the last element as whether
//        // it is unique or repeated, it hasn't
//        // stored previously
//        temp[j++] = arr[n-1];
//
//        // Modify original array
//        for (int i=0; i<j; i++)
//            arr[i] = temp[i];
//
//        return j;
//    }

    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


}

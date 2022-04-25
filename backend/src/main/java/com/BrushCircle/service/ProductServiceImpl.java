package com.BrushCircle.service;

import com.BrushCircle.dto.UpdateProductDTO;
import com.BrushCircle.dto.UserDTO;
import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import com.BrushCircle.repository.ProductRepository;
import com.BrushCircle.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    public static String uploadDirectory = System.getProperty("user.dir") + "/BrushCircleUploads";

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Product registerProduct(User user, Product product, MultipartFile file) throws Exception {
        log.info("Running RegisterProduct");
        try {
            User existingUser = userRepository.findByEmail(user.getEmail());
            log.info("\nExisting User Info:     " + existingUser);

            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            Files.write(fileNameAndPath, file.getBytes());

            product.setFilename(file.getOriginalFilename());
            product.setDate(LocalDate.now());
            product.setUser(existingUser); //*NOTE* Given the table relation it is ideal to associate the user to the product not the other way around

            userRepository.save(existingUser);
            productRepository.save(product);

            Product existingProduct = productRepository.findByTitle(product.getTitle());
            if (existingProduct == null){
                throw new Exception();
            }

            log.info("\nExisting Product Info:  " + existingProduct);
            return existingProduct;
        } catch (Exception e) {
            log.info("\n[Error Found] Product was not registered...");
            log.info("\nUser Info RQ:       " + user);
            log.info("\nProduct Info RQ:    " + product);
            log.info("\nFile Info:          "
                    + "\n" + file.getOriginalFilename()
                    + "\n" + file.getContentType());
        }
        return null;
    }

    public Product getProductInfo(Product product) throws Exception {
        log.info("Getting Product Info");
        Product existingProduct = productRepository.findByTitle(product.getTitle());
        return existingProduct;
    }

    public Product update(UpdateProductDTO updateProductDTO) throws Exception {
        log.info("Updating Current Product Info");

        User existingUser = userRepository.findByEmail(updateProductDTO.getUser().getEmail());
        Product existingProduct = productRepository.findByTitle(updateProductDTO.getProduct().getTitle());

        try {
            if (existingUser == null || existingProduct == null) {
                throw new Exception();
            }
            copyNonNullProperties(updateProductDTO.getProduct(), existingProduct);
            productRepository.save(existingProduct);
            return existingProduct;
        } catch (Exception e) {
            log.info("\n[Error Found] User from Product(s) does not match..."
                    + "\n User Expected:        " + existingUser
                    + "\n Product Expected:     " + existingProduct
            );
        }
        return null;
    }

    public UserDTO delete(UpdateProductDTO updateProductDTO) throws Exception {
        log.info("Updating Current Product Info");
        Product existingProduct = productRepository.findByTitle(updateProductDTO.getProduct().getTitle());
        User existingUser = userRepository.findByEmail(existingProduct.getUser().getEmail());
        UserDTO userDTO = new UserDTO();
        Boolean isAdmin = false;

        try {
            if (updateProductDTO.getUser().getRole().equals("ADMIN")) {
                isAdmin = true;
            }
            if (existingProduct == null) {
                log.info("Product Not Found In Database");
                throw new Exception();
            }
            if (!existingProduct.getUser().getEmail().equals(updateProductDTO.getUser().getEmail()) && isAdmin == false)
            {
                log.info("Product User and Logged In User Do Not Match");
                throw new Exception();
            }

            log.info("\nDeleting Image");
            Path fileNameAndPath = Paths.get(uploadDirectory, existingProduct.getFilename());
            Files.delete(fileNameAndPath);

            log.info("\nRunning Repository Actions");
            productRepository.deleteById(existingProduct.getId());
            userRepository.save(existingUser);

            userDTO.setUser(existingUser);
            userDTO.setProduct(existingUser.getProducts());

            return userDTO;
        } catch (Exception e) {
            log.info("\n[Error Found] User from Product(s) does not match..."
                    + "\n User Expected:        " + existingUser
                    + "\n Product Provided:     " + existingProduct
            );
        }
        return null;
    }

    public List<Product> getProductList(User user) throws Exception {
        log.info("Updating Current Product Info");
        User existingUser = userRepository.findByEmail(user.getEmail());
        List<Product> existingList = productRepository.findByUser(existingUser);
        try {
            if (existingList == null) {
                throw new Exception();
            }
            return existingList;
        } catch (Exception e) {
            log.info("\n[Error Found] User does not match..."
                    + "\n User Expected:    " + user);
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

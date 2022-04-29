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
    public List<Product> registerProduct(User user, MultipartFile file) throws Exception {
        log.info("Running RegisterProduct");
        Product product = new Product();
        try {
            User existingUser = userRepository.findByEmail(user.getEmail());
            log.info("\nExisting User Info:     " + existingUser);

            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            Files.write(fileNameAndPath, file.getBytes());
            String customTitle = getFileNameNoExtension(file.getOriginalFilename());

            product.setTitle(customTitle);
            product.setFilename(file.getOriginalFilename());
            product.setDate(LocalDate.now());
            product.setPrice(0);
            product.setLength(0);
            product.setWidth(0);
            product.setStyle("");
            product.setDescription("");
            product.setTags("");
            product.setUser(existingUser); //*NOTE* Given the table relation it is ideal to associate the user to the product not the other way around
            productRepository.save(product);


            Optional<Product> existingProduct = productRepository.findById(product.getId());
            if (existingProduct.isEmpty()) {
                log.info("\nExisting Product Info:  " + existingProduct);
                throw new Exception();
            }

            log.info("\nGetting List of Products from User");
            List<Product> existingList = getProductList(user);

            log.info("\nList of Products:   " + existingList);
            return existingList;

        } catch (Exception e) {
            getLogs(user, file, product);
            return null;
        }
    }

    public Product getProductInfo(Product product) throws Exception {
        log.info("Getting Product Info");
        Optional<Product> existingProduct = productRepository.findById(product.getId());
        log.info("Existing Product Details: " + existingProduct);
        return existingProduct.orElse(null);
    }

    public Product update(UpdateProductDTO updateProductDTO) throws Exception {
        log.info("Updating Current Product Info");

        User existingUser = userRepository.findByEmail(updateProductDTO.getUser().getEmail());
        Optional<Product> existingProduct = productRepository.findById(updateProductDTO.getProduct().getId());

        try {
            if (existingUser == null || existingProduct.isEmpty()) {
                throw new Exception();
            }
            copyNonNullProperties(updateProductDTO.getProduct(), existingProduct.get());
            productRepository.save(existingProduct.get());
            return existingProduct.get();
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
        User existingUser;
        Optional<Product> existingProduct = productRepository.findById(updateProductDTO.getProduct().getId());
        try {
            if (existingProduct.isPresent()) {
                existingUser = userRepository.findByEmail(existingProduct.get().getUser().getEmail());

                UserDTO userDTO = new UserDTO();
                Boolean isAdmin = true;

                try {
                    if (updateProductDTO.getUser().getRole().equals("USER")) {
                        isAdmin = false;
                    }

                    if (!existingProduct.get().getUser().getEmail().equals(updateProductDTO.getUser().getEmail()) && !isAdmin) {
                        log.info("\nProduct User and Logged In User Do Not Match");
                        throw new Exception();
                    }

//                    log.info("\nDeleting Image");
//                    Path fileNameAndPath = Paths.get(uploadDirectory, existingProduct.get().getFilename());
//                    Files.delete(fileNameAndPath);

                    log.info("\nRunning Repository Actions");
                    productRepository.deleteById(existingProduct.get().getId());
                    userRepository.save(existingUser);

                    userDTO.setUser(existingUser);
                    userDTO.setProduct(existingUser.getProducts());

                    return userDTO;
                } catch (Exception e) {
                    log.info("\nException Found"
                            + "\n User Expected:        " + existingUser
                            + "\n Product Provided:     " + existingProduct.get()
                    );
                }
            } else {
                log.info("Product Not Found In Database");
                throw new Exception();
            }
        } catch (Exception e) {
            log.info("Exception Found");
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductList(User user) throws Exception {
        log.info("Getting Current Users Product(s)");
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
            return null;
        }
    }

    @Override
    public List<String> removeStyleDuplicates(String[] styleList) throws Exception {
        int i, j;
        int k = 0;
        boolean t = false;

        for (i = 0; i < styleList.length; i++) {
            for (j = 0; j < styleList.length; j++) {
                if ((styleList[i].equals(styleList[j])) && (j > i)) {
                    t = true;
                }
            }
            if (t) {
                k++;
            }
        }
        String[] styleList1 = new String[k];
        for (i = 0; i < styleList.length; i++) {
            for (j = 0; j < styleList.length; j++) {
                if (!(styleList[i].equals(styleList[j])) && (j > i)) {
                    t = true;
                }
            }
            if (t) {
                styleList1[i] = styleList[i];
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

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public String getFileNameNoExtension(String fileName) {
        if(fileName.indexOf(".")>0)
        {
            return fileName.substring(0, fileName.lastIndexOf("."));
        } else {
            return fileName;
        }
    }

    public void getLogs(User user, MultipartFile file, Product product){
        log.info("\nUser Info:      " + user);
        log.info("\nFile Info:      "
                + "\n" + file.getOriginalFilename()
                + "\n" + file.getContentType());
        if(!(product == null)) {
            log.info("\nProduct Info:   " + product);
        }
    }
}

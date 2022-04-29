package com.BrushCircle.service;

import com.BrushCircle.dto.*;
import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import com.BrushCircle.repository.ProductRepository;
import com.BrushCircle.repository.UserRepository;
import com.amazonaws.services.route53.model.HealthCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    CrudRepository crudRepository;

    @Override
    public List<User> getUsers(User admin) throws Exception {
        log.info("Running Admin getUsers");

//        List<User> userList = userRepository.getAllRegUsers(); //TODO Fix
        List<User> userList = new ArrayList<>(userRepository.findAllByRole("USER"));
        try {
            for (User user: userList)
            {
                log.info("\nUser Info:  " + user);
            }
            if (admin == null || admin.getRole().equals("USER")) {
                throw new Exception();
            } else if (userList.isEmpty()) {
                throw new Exception();
            } else {
                return userList;
            }
        } catch (Exception e) {
            log.info("\n[Error Found] Admin was not found..."
                    + "\n Admin Expected:   " + admin.getEmail()
                    + "\n Users Retrieved:  " + userList);
        }
        return null;
    }

    @Override
    public UserDTO getUserData(AdminGetUserDataDTO adminGetUserDataDTO) {
        UserDTO result = new UserDTO();
        Optional<User> target = userRepository.findById(adminGetUserDataDTO.getFilter()); //Assuming Filter equals ID Value
        User admin = userRepository.findByEmail(adminGetUserDataDTO.getUser().getEmail());
        try {
            if (target.isPresent() && admin.getRole().equals("ADMIN")) {
                result.setUser(target.get());
                result.setProduct(target.get().getProducts());
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            log.info("\n[Error Found] Admin or Target was not found..."
                    + "\n Admin Expected:   " + admin.getEmail()
                    + "\n Results Retrieved:  " + result);
        }
        return  result;
    }

    @Override
    public UserSearchDTO searchUser(AdminSearchDTO adminSearchDTO) {
        UserSearchDTO result = new UserSearchDTO();
        User admin = userRepository.findByEmail(adminSearchDTO.getUser().getEmail());
        User target = userRepository.findByEmail(adminSearchDTO.getFilter()); //Assuming Filter equals Email Value

        if (target == null || admin.getRole().equals("USER")) {
            result.setMessage("User Not Found");
            log.info("\n[Error Found] Admin or Target was not found..."
                    + "\nAdmin Expected:        " + admin.getEmail()
                    + "\nUser Expected:         " + adminSearchDTO.getFilter()
                    + "\nResults Retrieved:    " + result);
            return result;
        }

        result.setMessage("User was found");
        result.setUser(target);
        return result;
    }

    @Override
    public User registerUser(AdminUpdateUserDTO updateUserDTO) {
        log.info("Running RegisterUser");
        try {
            if (updateUserDTO.getUser().getEmail() == null || updateUserDTO.getUser().getPassword() == null || updateUserDTO.getAdmin().getRole().equals("USER")) {
                throw new Exception();
            }

            User newUser = new User(updateUserDTO.getUser().getEmail(), updateUserDTO.getUser().getPassword());
            userRepository.save(newUser);
            User registeredUser = userRepository.findByEmail(newUser.getEmail());
            return registeredUser;

        } catch (Exception e) {
            log.info("\n[Error Found] User Email was not found..."
                    + "\n Create User Form Info: " + updateUserDTO);
            return null;
        }
    }

    @Override
    public User update(AdminUpdateUserDTO updateUserDTO) {
        try {
            if (updateUserDTO.getUser() == null || updateUserDTO.getAdmin().getRole().equals("USER")) {
                throw new Exception();
            }

            User existing = userRepository.findByEmail(updateUserDTO.getUser().getEmail());
            copyNonNullProperties(updateUserDTO.getUser(), existing);
            userRepository.save(existing);

            return existing;
        } catch (Exception e) {
            log.info("\nError Found:"
                    + "\nAdminUpdateUserDTO:    " + updateUserDTO.toString());
            return null;
        }
    }

    @Override
    public void deleteUser(AdminUpdateUserDTO updateUserDTO) {
        log.info("Running Admin - Delete User");
        try {
            User existingUser = userRepository.findByEmail(updateUserDTO.getUser().getEmail());
            User existingAdmin = userRepository.findByEmail(updateUserDTO.getAdmin().getEmail());

            if (existingAdmin == null || existingUser == null || !existingAdmin.getRole().equals("ADMIN")) {
                throw new Exception();
            }

            List<Product> productList = existingUser.getProducts();

            productList.forEach(product -> {
                Optional<Product> targetProduct = productRepository.findById(product.getId());
                targetProduct.ifPresent(value -> productRepository.delete(value));
            });

            userRepository.deleteById(existingUser.getId());

        } catch (Exception e) {
            log.info("\nError Found - User was not deleted");
        }
    }

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

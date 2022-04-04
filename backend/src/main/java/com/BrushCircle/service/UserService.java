package com.BrushCircle.service;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import graphql.schema.DataFetcher;

import java.util.List;

public interface UserService {
    DataFetcher<User> getUserByQuery();

    DataFetcher<List<User>> getAllUsersByQuery();

    User findUserById(Long productId);

    List<User> findAllUsers();

    User updateProfile(String email, User user);

    List<User> deleteUser(String username, User user);

    List<Product> getProducts(Long id);

    User findUserByEmail(String email);
}

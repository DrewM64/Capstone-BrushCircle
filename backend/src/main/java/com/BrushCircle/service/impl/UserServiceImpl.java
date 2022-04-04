package com.BrushCircle.service.impl;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import com.BrushCircle.repository.ProductRepository;
import com.BrushCircle.repository.UserRepository;
import com.BrushCircle.service.UserService;
import graphql.schema.DataFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
//    private final ReviewRepository reviewRepository;

    @Override
    public DataFetcher<User> getUserByQuery() {
        return dataFetchingEnvironment -> {
            Long userId = Long.parseLong(dataFetchingEnvironment.getArgument("id"));
            return userRepository.findById(userId).get();
        };
    }

    @Override
    public User updateProfile(String email, User user) {
        User userFromDb = userRepository.findByEmail(email);
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setPhoneNumber(user.getPhoneNumber());
        userFromDb.setAddress(user.getAddress());
        userFromDb.setState(user.getState());
        userFromDb.setPatreon(user.getPatreon());
        userFromDb.setCashapp(user.getCashapp());
        userFromDb.setTitle(user.getTitle());
        userFromDb.setBiography(user.getBiography());
        return userFromDb;
    }

        @Override
        public List<User> deleteUser (String email, User user){
            user.getProducts().forEach((product -> productRepository.deleteById(product.getId())));
            userRepository.delete(user);
            return userRepository.getAllUsers();
        }

        @Override
        public List<Product> getProducts (Long id){
            return null;
        }

        @Override
        public DataFetcher<List<User>> getAllUsersByQuery () {
            return null;
        }

        @Override
        public User findUserById (Long userId){
            return userRepository.findById(userId).get();
        }

        @Override
        public List<User> findAllUsers () {
            return null;
        }

        @Override
        public User findUserByEmail (String email){
            return userRepository.findByEmail(email);
        }

//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.
//    }
}


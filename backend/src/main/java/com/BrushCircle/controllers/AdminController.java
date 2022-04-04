package com.BrushCircle.controllers;

import com.BrushCircle.exception.InputFieldException;
import com.BrushCircle.mapper.ProductMapper;
import com.BrushCircle.mapper.UserMapper;
import com.BrushCircle.model.Product;
import com.BrushCircle.payload.user.UserRequest;
import com.BrushCircle.payload.user.UserResponse;
import com.BrushCircle.repository.UserRepository;
import com.BrushCircle.service.graphql.GraphQLProvider;
import graphql.ExecutionResult;
//import graphql.servlet.GraphQLProvider;
import graphql.servlet.internal.GraphQLRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    private final UserMapper userMapper;
    private final ProductMapper productMapper;
//    private final OrderMapper orderMapper;
    private final GraphQLProvider graphQLProvider;

    @GetMapping("/get")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userMapper.findAllUsers());
    }

    @PostMapping("/search")
    public ResponseEntity<ExecutionResult> getUserByQuery(@RequestBody GraphQLRequest request) {
        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
    }

    @PostMapping("/getuserdata/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userMapper.findUserById(userId));
    }

    @PutMapping("/updateuser")
    public ResponseEntity<UserResponse> updateUser(String email, @RequestPart("user") @Valid UserRequest user,
                                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(userMapper.updateProfile(email, user));
        }
    }

    @DeleteMapping("/deleteuser")
    public String deleteUser(Long userId) {
        return "deleteUser api accessed";
    }

    @PutMapping("/updateproduct")
    public String updateProduct(Long userId) {
        return "updateProduct api accessed";
    }

    @PostMapping("/createuser")
    public String createUser() {
        return "createUser api accessed";
    }

}

package com.BrushCircle.controllers;

import com.BrushCircle.mapper.ProductMapper;
import com.BrushCircle.mapper.UserMapper;
import graphql.ExecutionResult;
import graphql.servlet.GraphQLProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/api/v1/admin")
public class AdminController {

//    private final UserMapper userMapper;
//    private final ProductMapper productMapper;
//    private final OrderMapper orderMapper;
//    private final GraphQLProvider graphQLProvider;

//    @PostMapping("/add")
//    public ResponseEntity<ProductResponse> addProduct(@RequestPart(name = "file", required = false) MultipartFile file,
//                                                      @RequestPart("product") @Valid ProductRequest product,
//                                                      BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new InputFieldException(bindingResult);
//        } else {
//            return ResponseEntity.ok(productMapper.saveProduct(product, file));
//        }
//    }
//
//    @PostMapping("/edit")
//    public ResponseEntity<ProductResponse> updateProduct(@RequestPart(name = "file", required = false) MultipartFile file,
//                                                         @RequestPart("product") @Valid ProductRequest product,
//                                                         BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new InputFieldException(bindingResult);
//        } else {
//            return ResponseEntity.ok(productMapper.saveProduct(product, file));
//        }
//    }
//
//    @DeleteMapping("/delete/{productId}")
//    public ResponseEntity<List<ProductResponse>> deleteProduct(@PathVariable(value = "productId") Long productId) {
//        return ResponseEntity.ok(productMapper.deleteOrder(productId));
//    }
//
//    @GetMapping("/orders")
//    public ResponseEntity<List<OrderResponse>> getAllOrders() {
//        return ResponseEntity.ok(orderMapper.findAllOrders());
//    }
//
//    @PostMapping("/order")
//    public ResponseEntity<List<OrderResponse>> getUserOrdersByEmail(@RequestBody UserRequest user) {
//        return ResponseEntity.ok(orderMapper.findOrderByEmail(user.getEmail()));
//    }
//
//    @DeleteMapping("/order/delete/{orderId}")
//    public ResponseEntity<List<OrderResponse>> deleteOrder(@PathVariable(value = "orderId") Long orderId) {
//        return ResponseEntity.ok(orderMapper.deleteOrder(orderId));
//    }
//
//    @GetMapping("/user/{id}")
//    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Long userId) {
//        return ResponseEntity.ok(userMapper.findUserById(userId));
//    }
//
//    @GetMapping("/user/all")
//    public ResponseEntity<List<UserResponse>> getAllUsers() {
//        return ResponseEntity.ok(userMapper.findAllUsers());
//    }
//
//    @PostMapping("/graphql/user")
//    public ResponseEntity<ExecutionResult> getUserByQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }
//
//    @PostMapping("/graphql/user/all")
//    public ResponseEntity<ExecutionResult> getAllUsersByQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }
//
//    @PostMapping("/graphql/orders")
//    public ResponseEntity<ExecutionResult> getAllOrdersQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }
//
//    @PostMapping("/graphql/order")
//    public ResponseEntity<ExecutionResult> getUserOrdersByEmailQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }
}

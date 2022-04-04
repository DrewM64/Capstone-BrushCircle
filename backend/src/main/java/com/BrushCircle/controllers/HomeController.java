package com.BrushCircle.controllers;

import com.BrushCircle.exception.InputFieldException;
import com.BrushCircle.mapper.UserMapper;
import com.BrushCircle.payload.user.UserRequest;
import com.BrushCircle.payload.user.UserResponse;
import com.BrushCircle.service.graphql.GraphQLProvider;
import graphql.ExecutionResult;
import graphql.servlet.internal.GraphQLRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import com.BrushCircle.exception.InputFieldException;
import com.BrushCircle.mapper.UserMapper;
import com.BrushCircle.payload.user.UserRequest;
import com.BrushCircle.payload.user.UserResponse;
import com.BrushCircle.service.graphql.GraphQLProvider;
import graphql.ExecutionResult;
import graphql.servlet.internal.GraphQLRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/popularcategories")
    public String getPopularCategories() {
        return "getPopularCategories was called";
    }

    @GetMapping("/products")
    public String getRandomProducts() {
        return "getRandomProducts was called";
    }
}

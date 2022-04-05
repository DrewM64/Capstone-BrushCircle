package com.BrushCircle.controllers;

//import com.BrushCircle.exception.InputFieldException;
//import com.BrushCircle.mapper.UserMapper;
import com.BrushCircle.model.Product;
//import com.BrushCircle.payload.user.UserRequest;
//import com.BrushCircle.payload.user.UserResponse;
import com.BrushCircle.repository.UserRepository;
//import com.BrushCircle.service.graphql.GraphQLProvider;
//import graphql.ExecutionResult;
//import graphql.servlet.internal.GraphQLRequest;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserRepository userRepository;

//    private final UserMapper userMapper;
//    private final GraphQLProvider graphQLProvider;
//    private final SimpMessagingTemplate messagingTemplate;

    @PostMapping("/register")
    public String registerUser() {
        return "createUser was called";
    }

    @PostMapping("/login")
    public String loginUser() {
        return "loginUser was called";
    }

    @PostMapping("/newprofilephoto")
    public String newProfilePhoto() {
        return "productsList was called";
    }

    @PostMapping("/resetprofilephoto")
    public String resetProfilePhoto() {
        return "productsList was called";
    }

    @PostMapping("/update")
    public String updateUser() {
        return "productsList was called";
    }

    @PostMapping("/get")
    public String getUserInfo() {
        return "productsList was called";
    }

}

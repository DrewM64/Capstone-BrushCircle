package com.BrushCircle.controllers;

//import com.BrushCircle.exception.InputFieldException;
//import com.BrushCircle.mapper.UserMapper;

import com.BrushCircle.dto.UserDTO;
import com.BrushCircle.model.*;
//import com.BrushCircle.payload.user.UserRequest;
//import com.BrushCircle.payload.user.UserResponse;
//import com.BrushCircle.repository.UserRepository;
//import com.BrushCircle.service.graphql.GraphQLProvider;
//import graphql.ExecutionResult;
//import graphql.servlet.internal.GraphQLRequest;
//import lombok.RequiredArgsConstructor;
import com.BrushCircle.repository.UserRepository;
import com.BrushCircle.service.AdminService;
import com.BrushCircle.service.ProductService;
import com.BrushCircle.service.UserService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.BrushCircle.model.UserSpecification;

//import javax.validation.Valid;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000") //TODO May need to be added to all mappings
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    ProductService productService;

    //    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;
//    private final GraphQLProvider graphQLProvider;
//    private final SimpMessagingTemplate messagingTemplate;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
    })
    @RequestMapping(
            value = "/get",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> getUsers(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "Admin Logged In") User admin) throws Throwable {
        log.info("\nAdmin Info:   " + admin.toString());
        List<User> response = adminService.getUsers(admin);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
    })
    @RequestMapping(
            value = "/search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> searchUser(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "User Info Filter") @Valid User filter) throws Throwable {

//        Specification<User> spec = new UserSpecification(filter);
//
//        List<User> result = userRepository.findAllUsers(spec);
//        return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>("API Reached", HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
    })
    @RequestMapping(
            value = "/getuserdata",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUserData(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "Admin Object") User admin,
            @RequestBody @ApiParam(value = "Target ID") Long targetId,
            @RequestBody @ApiParam(value = "Target Product") String targetProductArray) throws Throwable {
        UserDTO result = new UserDTO();
        Optional<User> target = userRepository.findById(targetId);
        result.setUser(target.get());
        result.setProduct(target.get().getProducts());
        return new ResponseEntity<UserDTO>(result, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
    })
    @RequestMapping(
            value = "/updateuser",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateUserData(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "Admin Object") User admin,
            @RequestBody @ApiParam(value = "Target Object") User target) throws Throwable {
        User response = userService.update(target);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
    })
    @RequestMapping(
            value = "/deleteuser",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteUserData(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "Admin Object") User admin,
            @RequestBody @ApiParam(value = "Target Object") User target) throws Throwable {
        userRepository.deleteById(target.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Product.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
    })
    @RequestMapping(
            value = "/updateproduct",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> updateProduct(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by product") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "Current User") User admin,
            @RequestBody @ApiParam(value = "Current Product") Product currentProduct) throws Throwable {
        Product response = productService.update(admin, currentProduct);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Product.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
    })
    @RequestMapping(
            value = "/deleteproduct",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteProduct(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by product") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "Admin Object") User admin,
            @RequestBody @ApiParam(value = "Current Product") Product currentProduct,
            @RequestBody @ApiParam(value = "Target User") User target) throws Throwable {
        List<Product> response = productService.delete(target, currentProduct);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "OK", response = User.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = ErrorMessage.class),
//            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
//            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
//    })
//    @RequestMapping(
//            value = "/createuser",
//            method = RequestMethod.POST,
//            produces = {MediaType.APPLICATION_JSON_VALUE},
//            consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<User> createUser(
////        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
////        @Valid
//            @RequestBody @ApiParam(value = "Admin Object") User admin,
//            @RequestBody @ApiParam(value = "New Username") String newUsername,
//            @RequestBody @ApiParam(value = "New Password") String newPassword) throws Throwable {
//        User newUser = new User(newUsername,newPassword);
//        userService.registerUser(newUser);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}

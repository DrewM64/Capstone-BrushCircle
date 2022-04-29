package com.BrushCircle.controllers;

//import com.BrushCircle.exception.InputFieldException;
//import com.BrushCircle.mapper.UserMapper;

import com.BrushCircle.dto.*;
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

    @Autowired
    ProductService productService;

    @Autowired
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
        log.info("\nAdmin Info:   " + admin);
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
            @RequestBody AdminSearchDTO adminSearchDTO) throws Throwable {

//        Specification<User> spec = new UserSpecification(filter);
//        List<User> result = userRepository.findAllUsers(spec);
//        return new ResponseEntity<>(result, HttpStatus.OK);

        UserSearchDTO response = adminService.searchUser(adminSearchDTO);
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
            value = "/getuserdata",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUserData(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody AdminGetUserDataDTO adminGetUserDataDTO) throws Throwable {
        UserDTO result = adminService.getUserData(adminGetUserDataDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
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
            @RequestBody AdminUpdateUserDTO updateUserDTO) throws Throwable {
        User response = adminService.update(updateUserDTO);
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
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteUserData(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody AdminUpdateUserDTO updateUserDTO) throws Throwable {
        adminService.deleteUser(updateUserDTO);
        return new ResponseEntity<>("Successful Delete",HttpStatus.OK);
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
            @RequestBody UpdateProductDTO updateProductDTO) throws Throwable {
        Product response = productService.update(updateProductDTO);
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
            @RequestBody UpdateProductDTO updateProductDTO) throws Throwable {
        UserDTO response = productService.delete(updateProductDTO);
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
            value = "/createuser",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> createUser(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody AdminUpdateUserDTO adminUpdateUserDTO) throws Throwable {
        User response = adminService.registerUser(adminUpdateUserDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

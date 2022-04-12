package com.BrushCircle.controllers;

//import com.BrushCircle.exception.InputFieldException;
//import com.BrushCircle.mapper.UserMapper;
import com.BrushCircle.dto.RegisterFormDTO;
import com.BrushCircle.model.ErrorMessage;
import com.BrushCircle.model.Product;
//import com.BrushCircle.payload.user.UserRequest;
//import com.BrushCircle.payload.user.UserResponse;
//import com.BrushCircle.repository.UserRepository;
//import com.BrushCircle.service.graphql.GraphQLProvider;
//import graphql.ExecutionResult;
//import graphql.servlet.internal.GraphQLRequest;
//import lombok.RequiredArgsConstructor;
import com.BrushCircle.model.User;
import com.BrushCircle.repository.UserRepository;
import com.BrushCircle.service.ProductService;
import com.BrushCircle.service.UserService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//import javax.validation.Valid;
import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000") //TODO May need to be added to all mappings
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;
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
        value = "/register",
        method = RequestMethod.POST,
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<User> registerUser(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody RegisterFormDTO registerForm) throws Throwable {
        System.out.println(registerForm.getEmail());
        System.out.println(registerForm.getPassword());
        User response = userService.registerUser(registerForm.getEmail(), registerForm.getPassword());
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
        value = "/login",
        method = RequestMethod.POST,
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> loginUser(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "User Login") User loginUser) throws Throwable {
        User response = userService.login(loginUser);
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
        value ="/newprofilephoto",
        method = RequestMethod.POST,
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity <?> newProfilePhoto(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
        @RequestBody @ApiParam(value = "Current User") User currentUser) throws Throwable {
        User response = userService.addProfPic(currentUser);
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
        value ="/resetprofilephoto",
        method = RequestMethod.POST,
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> resetProfilePhoto(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "Current User") User currentUser) throws Throwable {
        User response = userService.resetProfPic(currentUser);
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
        value ="/update",
        method = RequestMethod.POST,
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> updateUser(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
             @RequestBody @ApiParam(value = "Current User") User currentUser) throws Throwable {
        User response = userService.update(currentUser);
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
        value ="/get",
        method = RequestMethod.POST,
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> getUserInfo(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by user") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "User Email") String email) throws Throwable {
        User response = userService.getUserInfo(email);
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
            value ="/products",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProductList(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by product") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "Current User") User currentUser) throws Throwable {
        List<Product> response = productService.getProductList(currentUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

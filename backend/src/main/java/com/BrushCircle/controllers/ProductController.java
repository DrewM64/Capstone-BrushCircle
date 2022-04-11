package com.BrushCircle.controllers;

import com.BrushCircle.model.ErrorMessage;
import com.BrushCircle.model.Product;
import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import com.BrushCircle.service.ProductService;
import com.BrushCircle.service.ProductService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //TODO May need to be added to all mappings
@Slf4j
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Product.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
    })
    @RequestMapping(
            value = "/upload",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> registerProduct(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by product") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "New Product to Register Information") Product newProduct, MultipartFile file) throws Throwable {
        Product response = productService.registerProduct(newProduct, file);
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
            value = "/upload",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> getProduct(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by product") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "New Product to Register Information") Product product) throws Throwable {
        Product response = productService.getProductInfo(product);
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
            value ="/update",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> updateProduct(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by product") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "Current User") User currentUser,
            @RequestBody @ApiParam(value = "Current Product") Product currentProduct) throws Throwable {
        Product response = productService.update(currentUser, currentProduct);
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
            value ="/delete",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteProduct(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by product") String authorization,
//        @Valid
            @RequestBody @ApiParam(value = "Current User") User currentUser,
            @RequestBody @ApiParam(value = "Current Product") Product currentProduct) throws Throwable {
        List<Product> response = productService.delete(currentUser, currentProduct);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

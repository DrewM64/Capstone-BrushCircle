package com.BrushCircle.controllers;

import com.BrushCircle.dto.UpdateProductDTO;
import com.BrushCircle.dto.UserDTO;
import com.BrushCircle.model.ErrorMessage;
import com.BrushCircle.model.Product;
import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import com.BrushCircle.repository.ProductRepository;
import com.BrushCircle.service.ProductService;
import com.BrushCircle.service.ProductService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

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
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<List<Product>> registerProduct(
//        @RequestHeader(value = "Authorization") @ApiParam(required = true, value = "JWT Token to authorize request made by product") String authorization,
//        @Valid
            @RequestPart("user") User user,
            @RequestPart("file") MultipartFile file) throws Throwable {
        try {

            if (user == null || file == null) {
                log.info("\nRequest Body gave null values");
                productService.getLogs(user, file, null);
                throw new Exception();
            }

            String customTitle = productService.getFileNameNoExtension(file.getOriginalFilename());
            log.info("\nTitle of Product is:  " + customTitle);

            List<Product> response = productService.registerProduct(user, file);
            if (response == null) {
                log.info("\nResponse body returned null");
                throw new Exception();
            }
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch(Exception e) {
            log.info("Exception Found");
            e.printStackTrace();
            return null;
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Product.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
    })
    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProduct(
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
            value ="/delete",
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
}

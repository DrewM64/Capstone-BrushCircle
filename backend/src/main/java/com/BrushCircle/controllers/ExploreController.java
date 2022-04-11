package com.BrushCircle.controllers;

//import com.BrushCircle.exception.InputFieldException;
//import com.BrushCircle.mapper.UserMapper;
import com.BrushCircle.dto.ProductDTO;
import com.BrushCircle.model.ErrorMessage;
import com.BrushCircle.model.Product;
//import com.BrushCircle.payload.user.UserRequest;
//import com.BrushCircle.payload.user.UserResponse;
//import com.BrushCircle.repository.UserRepository;
//import com.BrushCircle.service.graphql.GraphQLProvider;
//import graphql.ExecutionResult;
//import graphql.servlet.internal.GraphQLRequest;
//import lombok.RequiredArgsConstructor;
import com.BrushCircle.model.ProductSpecification;
import com.BrushCircle.model.User;
import com.BrushCircle.repository.ProductRepository;
import com.BrushCircle.service.ProductService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000") //TODO May need to be added to all mappings
@Slf4j
@RequestMapping("/explore")
public class ExploreController {

    //    @Autowired
//    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;
    //    @Autowired
    ProductService productService;
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
            value = "/home",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> randomImages() throws Exception {
        ProductDTO response = new ProductDTO();
        String[] styleList = productRepository.getStyles().toArray(new String[0]);
        List<String> categoryList = productService.removeStyleDuplicates(styleList);
        List<String> stylesAdded = new ArrayList<>();
        List<Product> productsAdded = new ArrayList<>();
        List<Product> allProductsFromStyle = new ArrayList<>();
        Collections.shuffle(categoryList);
        for (int i= 0; i < 4; i++) {
            String x = categoryList.get(i);
            stylesAdded.add(x);
            allProductsFromStyle = productRepository.findByProductStyle(x);
            Collections.shuffle(allProductsFromStyle);
            productsAdded.add(allProductsFromStyle.get(0));
        }
        response.setStyles(stylesAdded);
        response.setProducts(productsAdded);

        return new ResponseEntity<ProductDTO>(response, HttpStatus.OK);
    }
}

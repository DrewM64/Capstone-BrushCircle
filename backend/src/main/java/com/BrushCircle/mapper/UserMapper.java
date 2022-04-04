package com.BrushCircle.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import com.BrushCircle.payload.RegistrationRequest;
import com.BrushCircle.payload.product.ProductResponse;
import com.BrushCircle.payload.user.UserRequest;
import com.BrushCircle.payload.user.UserResponse;
import com.BrushCircle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;
    private final ProductMapper productMapper;
    private final UserService userService;

    private User convertToEntity(UserRequest userRequest) {
        return modelMapper.map(userRequest, User.class);
    }

    User convertToEntity(RegistrationRequest registrationRequest) {
        return modelMapper.map(registrationRequest, User.class);
    }

    UserResponse convertToResponseDto(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    public UserResponse findUserById(Long userId) {
        return convertToResponseDto(userService.findUserById(userId));
    }

//    public List<ProductResponse> getCart(List<Long> productsIds) {
//        return productMapper.convertListToResponseDto(userService.getCart(productsIds));
//    }

    public List<UserResponse> findAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public UserResponse updateProfile(String email, UserRequest userRequest) {
        return convertToResponseDto(userService.updateProfile(email, convertToEntity(userRequest)));
    }

    public List<ProductResponse> findProductsById(Long userId) {
        return productMapper.convertListToResponseDto(userService.getProducts(userId));
    }

    public Object deleteUser(String email, UserRequest userRequest) {
        return userService.deleteUser(email, convertToEntity(userRequest));
    }

    public Object findUserByEmail(String email) {
        return convertToResponseDto(userService.findUserByEmail(email));
    }
}

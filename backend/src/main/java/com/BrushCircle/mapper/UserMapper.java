package com.BrushCircle.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.BrushCircle.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
//
//    private final ModelMapper modelMapper;
//    private final ProductMapper productMapper;
//    private final UserService userService;
//
//    private User convertToEntity(UserRequest userRequest) {
//        return modelMapper.map(userRequest, User.class);
//    }
//
//    User convertToEntity(RegistrationRequest registrationRequest) {
//        return modelMapper.map(registrationRequest, User.class);
//    }
//
//    private Review convertToEntity(ReviewRequest reviewRequest) {
//        return modelMapper.map(reviewRequest, Review.class);
//    }
//
//    UserResponse convertToResponseDto(User user) {
//        return modelMapper.map(user, UserResponse.class);
//    }
//
//    public UserResponse findUserById(Long userId) {
//        return convertToResponseDto(userService.findUserById(userId));
//    }
//
//    public UserResponse findUserByEmail(String email) {
//        return convertToResponseDto(userService.findUserByEmail(email));
//    }
//
//    public List<ProductResponse> getCart(List<Long> productsIds) {
//        return productMapper.convertListToResponseDto(userService.getCart(productsIds));
//    }
//
//    public List<UserResponse> findAllUsers() {
//        return userService.findAllUsers()
//                .stream()
//                .map(this::convertToResponseDto)
//                .collect(Collectors.toList());
//    }
//
//    public UserResponse updateProfile(String email, UserRequest userRequest) {
//        return convertToResponseDto(userService.updateProfile(email, convertToEntity(userRequest)));
//    }
//
//    public ProductResponse addReviewToProduct(ReviewRequest reviewRequest, Long productId) {
//        return productMapper.convertToResponseDto(userService.addReviewToProduct(convertToEntity(reviewRequest), productId));
//    }
}

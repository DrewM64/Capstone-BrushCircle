package com.BrushCircle.service;

//import com.BrushCircle.model.RegisteredUser;
import com.BrushCircle.dto.LoginFormDTO;
import com.BrushCircle.dto.ProfilePhotoDTO;
import com.BrushCircle.dto.UserDTO;
import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
//    User registerUser(User newUser) throws Exception;
    User registerUser(String email, String password) throws Exception;
    User login(LoginFormDTO loginForm) throws Exception;
    User addProfPic(User user, MultipartFile file) throws Exception;
    User resetProfPic(User currentUser) throws Exception;
    User update(User currentUser) throws Exception;
    UserDTO getUserInfo(String email) throws Exception;
}

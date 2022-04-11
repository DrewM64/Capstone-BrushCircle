package com.BrushCircle.service;

//import com.BrushCircle.model.RegisteredUser;
import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User newUser) throws Exception;
    User login(User loginUser) throws Exception;
    User addProfPic(User currentUser) throws Exception;
    User resetProfPic(User currentUser) throws Exception;
    User update(User currentUser) throws Exception;
    User getUserInfo(String email) throws Exception;
}

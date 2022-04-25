package com.BrushCircle.service;

import com.BrushCircle.dto.*;
import com.BrushCircle.model.User;

import java.util.List;

public interface AdminService {
    List<User> getUsers(User admin) throws Exception;

    UserDTO getUserData(AdminGetUserDataDTO adminGetUserDataDTO);

    UserSearchDTO searchUser(AdminSearchDTO adminSearchDTO);

    User registerUser(AdminUpdateUserDTO adminUpdateUserDTO);

    User update(AdminUpdateUserDTO updateUserDTO);

    void deleteUser(AdminUpdateUserDTO updateUserDTO);
}

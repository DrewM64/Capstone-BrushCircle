package com.BrushCircle.service;

import com.BrushCircle.model.User;

import java.util.List;

public interface AdminService {
    List<User> getUsers(User admin) throws Exception;
}

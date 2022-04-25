package com.BrushCircle.dto;

import com.BrushCircle.model.User;

public class AdminUpdateUserDTO {

    private User admin;
    private User user;

    public AdminUpdateUserDTO() {
    }

    public AdminUpdateUserDTO(User admin, User user) {
        this.admin = admin;
        this.user = user;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AdminUpdateUserDTO{" +
                "admin=" + admin +
                ", user=" + user +
                '}';
    }
}

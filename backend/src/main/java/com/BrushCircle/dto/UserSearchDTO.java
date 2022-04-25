package com.BrushCircle.dto;

import com.BrushCircle.model.User;

import java.util.List;

public class UserSearchDTO {

    private User user;
    private String message;

    public UserSearchDTO() {
    }

    public UserSearchDTO(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserSearchDTO{" +
                "user=" + user +
                ", message='" + message + '\'' +
                '}';
    }
}

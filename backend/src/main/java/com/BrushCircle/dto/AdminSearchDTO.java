package com.BrushCircle.dto;

import com.BrushCircle.model.User;

public class AdminSearchDTO {
    private User user;
    private String filter;

    public AdminSearchDTO() {
    }

    public AdminSearchDTO(User user, String filter) {
        this.user = user;
        this.filter = filter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "AdminSearchDTO{" +
                "user=" + user +
                ", filter='" + filter + '\'' +
                '}';
    }
}

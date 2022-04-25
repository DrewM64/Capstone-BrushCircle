package com.BrushCircle.dto;

import com.BrushCircle.model.User;

public class AdminGetUserDataDTO {
    private User user;
    private Long filter;

    public AdminGetUserDataDTO() {
    }

    public AdminGetUserDataDTO(User user, Long filter) {
        this.user = user;
        this.filter = filter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getFilter() {
        return filter;
    }

    public void setFilter(Long filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "AdminGetUserDataDTO{" +
                "user=" + user +
                ", filter='" + filter + '\'' +
                '}';
    }
}

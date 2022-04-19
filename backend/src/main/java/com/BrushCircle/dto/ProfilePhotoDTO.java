package com.BrushCircle.dto;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProfilePhotoDTO {

    private User user;
    private MultipartFile file;


    public ProfilePhotoDTO() {
    }

    public ProfilePhotoDTO(User user, MultipartFile file) {
        this.user = user;
        this.file = file;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}

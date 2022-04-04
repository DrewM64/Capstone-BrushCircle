package com.BrushCircle.payload.product;

import com.BrushCircle.model.User;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class ProductResponse {
    private Long id;
    private String title; //name of artwork
    private Date date;
    private Integer price; //cost
    private String style; //art style
    private boolean featured;
    private String description; //art description
    private int width;
    private int length;
    private String tags;
    private String filename; //image file name
    private User user;
}

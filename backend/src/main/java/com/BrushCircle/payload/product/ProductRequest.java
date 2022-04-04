package com.BrushCircle.payload.product;

import com.BrushCircle.model.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProductRequest {

    private Long id;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String title; //name of artwork

    private Date date;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private Integer price; //cost

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String style; //art style

    private boolean featured;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String description; //art description

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private int width;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private int length;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String tags;

    private String filename; //image file name
    private User user;
}
package com.pratice.productcatalogservice.model.dto.product;

import com.pratice.productcatalogservice.model.entity.Category;
import lombok.Builder;

import java.util.Date;

@Builder
public class ProductDto {
    private Long id;
    private String name;
    private Date createdOn;
    private Date updatedOn;
    private String description;
    private String imageUrl;
    private Double price;
    private String categoryName;
}

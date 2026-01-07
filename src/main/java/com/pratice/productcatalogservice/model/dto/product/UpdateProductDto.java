package com.pratice.productcatalogservice.model.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private Long categoryId;
}

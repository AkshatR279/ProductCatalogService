package com.pratice.productcatalogservice.model.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchProductRequestDto {
    private Long productId;
    private Long categoryId;
    private String name;
}

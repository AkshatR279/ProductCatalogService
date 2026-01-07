package com.pratice.productcatalogservice.utils.convertors;

import com.pratice.productcatalogservice.model.dto.product.ProductDto;
import com.pratice.productcatalogservice.model.entity.Product;

public class ProductConvertors {
    public static ProductDto convertProductToProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .createdOn(product.getCreatedOn())
                .updatedOn(product.getUpdatedOn())
                .categoryName(product.getCategory().getName())
                .build();
    }
}

package com.pratice.productcatalogservice.service;

import com.pratice.productcatalogservice.model.dto.product.UpdateProductDto;
import com.pratice.productcatalogservice.model.entity.Product;

import java.util.List;

public interface ProductService {
    public Product updateProduct(UpdateProductDto request);
    public List<Product> getAllProducts();
}

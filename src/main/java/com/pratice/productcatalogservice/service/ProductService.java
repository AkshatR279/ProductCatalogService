package com.pratice.productcatalogservice.service;

import com.pratice.productcatalogservice.model.dto.product.SearchProductRequestDto;
import com.pratice.productcatalogservice.model.dto.product.UpdateProductDto;
import com.pratice.productcatalogservice.model.entity.Product;

import java.util.List;

public interface ProductService {
    public Product getProduct(Long id);
    public List<Product> getAllProducts();
    public Product updateProduct(UpdateProductDto request);
    public List<Product> getProducts(SearchProductRequestDto request);
}

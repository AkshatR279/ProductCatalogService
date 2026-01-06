package com.pratice.productcatalogservice.service.impl;

import com.pratice.productcatalogservice.model.entity.Product;
import com.pratice.productcatalogservice.repository.ProductRepository;
import com.pratice.productcatalogservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }
}

package com.pratice.productcatalogservice.service.impl;

import com.pratice.productcatalogservice.model.dto.product.ProductDto;
import com.pratice.productcatalogservice.model.dto.product.UpdateProductDto;
import com.pratice.productcatalogservice.model.entity.Category;
import com.pratice.productcatalogservice.model.entity.Product;
import com.pratice.productcatalogservice.repository.CategoryRepository;
import com.pratice.productcatalogservice.repository.ProductRepository;
import com.pratice.productcatalogservice.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product updateProduct(UpdateProductDto request) {
        Product product = new Product();
        if(request.getId() != 0){
            Optional<Product> existingProduct = productRepository.findById(request.getId());
            if(existingProduct.isEmpty()){
                throw new EntityNotFoundException("Product to be updated could not be found.");
            }

            product = existingProduct.get();
            product.setUpdatedOn(new Date());
        }

        Optional<Category> category = categoryRepository.findById(request.getCategoryId());
        if(category.isEmpty()){
            throw new EntityNotFoundException("Category not found.");
        }

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setImageUrl(request.getImageUrl());
        product.setPrice(request.getPrice());

        if(request.getId() == 0)
            product.setCreatedOn(new Date());

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }
}

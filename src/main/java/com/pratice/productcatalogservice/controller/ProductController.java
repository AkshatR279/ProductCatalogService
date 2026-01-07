package com.pratice.productcatalogservice.controller;

import com.pratice.productcatalogservice.model.dto.product.ProductDto;
import com.pratice.productcatalogservice.model.dto.product.UpdateProductDto;
import com.pratice.productcatalogservice.model.entity.Product;
import com.pratice.productcatalogservice.model.general.APIResponse;
import com.pratice.productcatalogservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/update")
    public APIResponse saveProduct(@RequestBody UpdateProductDto request){
        APIResponse response = new APIResponse();
        try{
            Product product = productService.updateProduct(request);
            ProductDto productDto = ProductDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .imageUrl(product.getImageUrl())
                    .price(product.getPrice())
                    .createdOn(product.getCreatedOn())
                    .updatedOn(product.getUpdatedOn())
                    .categoryName(product.getCategory().getName())
                    .build();

            response = APIResponse.builder()
                    .success(true)
                    .message("Product saved successfully.")
                    .internalMessage("Product saved successfully.")
                    .status(HttpStatus.OK)
                    .data(productDto)
                    .build();
        } catch (Exception e) {
            response = APIResponse.builder()
                    .success(false)
                    .message("Error saving product.")
                    .internalMessage(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        return response;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }


}

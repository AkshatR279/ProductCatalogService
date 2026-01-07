package com.pratice.productcatalogservice.controller;

import com.pratice.productcatalogservice.model.dto.product.ProductDto;
import com.pratice.productcatalogservice.model.dto.product.SearchProductRequestDto;
import com.pratice.productcatalogservice.model.dto.product.UpdateProductDto;
import com.pratice.productcatalogservice.model.entity.Product;
import com.pratice.productcatalogservice.model.general.APIResponse;
import com.pratice.productcatalogservice.service.ProductService;
import com.pratice.productcatalogservice.utils.convertors.ProductConvertors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.pratice.productcatalogservice.utils.convertors.ProductConvertors.convertProductToProductDto;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public APIResponse getProduct(@PathVariable Long id){
        try{
            Product product = productService.getProduct(id);
            ProductDto productDto = convertProductToProductDto(product);

            return APIResponse.builder()
                    .success(true)
                    .message("Product fetched successfully.")
                    .internalMessage("Product fetched successfully.")
                    .status(HttpStatus.OK)
                    .data(productDto)
                    .build();
        } catch (Exception e) {
            return APIResponse.builder()
                    .success(false)
                    .message("Error fetching product.")
                    .internalMessage(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @GetMapping
    public APIResponse getAllproducts(){
        try{
            List<Product> products = productService.getAllProducts();
            List<ProductDto> productDtoList = products.stream()
                    .map(ProductConvertors::convertProductToProductDto)
                    .toList();

            return APIResponse.builder()
                    .success(true)
                    .message("Products fetched successfully.")
                    .internalMessage("Products fetched successfully.")
                    .status(HttpStatus.OK)
                    .data(productDtoList)
                    .build();
        } catch (Exception e) {
            return APIResponse.builder()
                    .success(false)
                    .message("Error fetching products.")
                    .internalMessage(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PostMapping("/update")
    public APIResponse saveProduct(@RequestBody UpdateProductDto request){
        try{
            Product product = productService.updateProduct(request);
            ProductDto productDto = convertProductToProductDto(product);

            return APIResponse.builder()
                    .success(true)
                    .message("Product saved successfully.")
                    .internalMessage("Product saved successfully.")
                    .status(HttpStatus.OK)
                    .data(productDto)
                    .build();
        } catch (Exception e) {
            return APIResponse.builder()
                    .success(false)
                    .message("Error saving product.")
                    .internalMessage(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PostMapping("/search")
    public APIResponse searchProducts(@RequestBody SearchProductRequestDto request){
        try{
            List<Product> products = productService.getProducts(request);
            List<ProductDto> productDtoList = products.stream()
                    .map(ProductConvertors::convertProductToProductDto)
                    .toList();

            return APIResponse.builder()
                    .success(true)
                    .message("Products fetched successfully.")
                    .internalMessage("Products fetched successfully.")
                    .status(HttpStatus.OK)
                    .data(productDtoList)
                    .build();
        } catch (Exception e) {
            return APIResponse.builder()
                    .success(false)
                    .message("Error fetching products.")
                    .internalMessage(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }


}

package com.pratice.productcatalogservice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tbl_product")
@Getter
@Setter
public class Product extends BaseModel {
    private String description;
    private String imageUrl;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}

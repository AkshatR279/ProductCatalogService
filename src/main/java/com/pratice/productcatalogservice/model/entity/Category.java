package com.pratice.productcatalogservice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "tbl_category")
@Getter
@Setter
public class Category extends BaseModel {
    private String description;
    private String imageUrl;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}

package com.pratice.productcatalogservice.repository;

import com.pratice.productcatalogservice.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}

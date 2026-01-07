package com.pratice.productcatalogservice.repository;

import com.pratice.productcatalogservice.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("SELECT P " +
//            "FROM Product P " +
//            "WHERE (:productId = 0 OR P.id = :productId) " +
//            "AND (:categoryId = 0 OR P.category.id = :categoryId) " +
//            "AND (:name = '' OR LOWER(P.name) LIKE LOWER(CONCAT('%',:name,'%')))")
//    public List<Product> findProducts(@Param("productId") Long productId, @Param("categoryId") Long categoryId, @Param("name") String name);

//    @Query("""
//    SELECT p FROM Product p
//    JOIN FETCH p.category
//    WHERE (:productId IS NULL OR p.id = :productId)
//      AND (:categoryId IS NULL OR p.category.id = :categoryId)
//      AND (:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))
//""")
//    List<Product> findProducts(
//            @Param("productId") Long productId,
//            @Param("categoryId") Long categoryId,
//            @Param("name") String name
//    );

}

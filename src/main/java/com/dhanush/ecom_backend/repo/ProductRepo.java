package com.dhanush.ecom_backend.repo;

import com.dhanush.ecom_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    //    //JPl
//    @Query("SELECT p from Product p WHERE"+
//            "LOWER(p.name) LIKE LOWER (CONCAT('%', :keyword ,'%')) OR " +
//            "LOWER(p.description) LIKE LOWER (CONCAT('%', :keyword ,'%')) OR " +
//            "LOWER(p.brand) LIKE LOWER (CONCAT('%', :keyword ,'%')) OR " +
//            "LOWER(p.category) LIKE LOWER (CONCAT('%', :keyword ,'%')) ")
    @Query("SELECT p FROM Product p " +
            "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
//List<Product> search(@Param("keyword") String keyword);

    List<Product> searchProducts(String keyword);


}


package com.ra.repository;

import com.ra.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAllByProductNameContainingIgnoreCase(String name, Pageable pageable);
@Query(value = "select  p from Product p WHERE p.price between :start AND :end")
   Page<Product> findAllByProductPrice(@Param ("start") String start, @Param("end") String end, Pageable pageable);
    @Query(value = "SELECT p FROM Product p ORDER BY "
            + "CASE WHEN :byTo = 'asc' THEN p.price END ASC, "
            + "CASE WHEN :byTo = 'desc' THEN p.price END DESC")
    Page<Product> sortProductByPrice(@Param("byTo") String by,Pageable pageable);


}

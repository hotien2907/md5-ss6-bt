package com.ra.repository;

import com.ra.entity.Orders;
import com.ra.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}

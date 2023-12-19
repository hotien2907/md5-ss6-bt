package com.ra.repository;

import com.ra.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Orders,Integer> {
}

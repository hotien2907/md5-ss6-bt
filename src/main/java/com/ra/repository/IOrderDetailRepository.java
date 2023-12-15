package com.ra.repository;

import com.ra.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.repository.query.Param;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    @Query("SELECT od FROM OrderDetail od WHERE od.orders.order_id = :orderId")
    List<OrderDetail> findOrderDetailByOrderId(@Param("orderId") Integer orderId);
}

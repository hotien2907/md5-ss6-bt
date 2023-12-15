package com.ra.repository;

import com.ra.entity.OrderDetail;
import com.ra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderDetailRepository  extends JpaRepository<OrderDetail,Integer> {
    List<OrderDetail> findOrderDetailBy_OrderId(Integer orderId);
}

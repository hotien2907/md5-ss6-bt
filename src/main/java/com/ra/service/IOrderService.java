package com.ra.service;
import com.ra.dto.responseDto.ResponseOrder;
import com.ra.entity.Orders;
import com.ra.exception.CustomException;

import java.util.List;


public interface IOrderService {
    List<ResponseOrder> findAll();
    Orders save(Integer idUser, ResponseOrder requestOrder) throws CustomException;
    ResponseOrder findById(Integer id);
    void delete(Integer id);
}

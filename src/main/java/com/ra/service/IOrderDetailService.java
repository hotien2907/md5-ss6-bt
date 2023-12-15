package com.ra.service;

import com.ra.dto.responseDto.ResponseOrderDetail;
import com.ra.exception.CustomException;

import java.util.List;

public interface IOrderDetailService {
//    OrderDetail saveOrderDetailById(Integer idOrder,  RequestOrderDetail requestOrderDetail) throws CustomException;

    List<ResponseOrderDetail> findAllByOrderId(Integer orderId) throws CustomException;

}

package com.ra.controller;

import com.ra.dto.responseDto.ResponseOrderDetail;
import com.ra.entity.OrderDetail;
import com.ra.exception.CustomException;
import com.ra.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/detail")
public class OrderDetailController  {

    @Autowired
    IOrderDetailService orderDetailService;

    @GetMapping("/{idOrder}")
    public ResponseEntity<List<ResponseOrderDetail>> findAllByOrderId(@PathVariable Integer idOrder) throws CustomException {
        return new ResponseEntity<>(orderDetailService.findAllByOrderId(idOrder), HttpStatus.OK);
    }
}

package com.ra.controller;

import com.ra.dto.responseDto.ResponseOrder;
import com.ra.entity.Orders;
import com.ra.exception.CustomException;
import com.ra.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @PostMapping("/{idUser}")
    public ResponseEntity<Orders> addNewOrderToUserByIdUser(@PathVariable Integer idUser, @RequestBody ResponseOrder responseOrder) throws CustomException {
           return  new ResponseEntity<>(orderService.save(idUser,responseOrder), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ResponseOrder>> getAllOrders() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

}

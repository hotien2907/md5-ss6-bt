package com.ra.dto.responseDto;


import com.ra.entity.Product;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResponseOrderDetail {
    private int orderDetail_id;
    private int quantity;
    private Double price;
    private int order_id;
      private String userName;
    private Product product;
}

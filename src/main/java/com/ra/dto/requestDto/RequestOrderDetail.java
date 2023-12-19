package com.ra.dto.requestDto;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RequestOrderDetail {
    private Integer product_id ;
    private Integer quantity ;
    private Double price ;
}

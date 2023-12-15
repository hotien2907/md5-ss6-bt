package com.ra.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetail_id;
    private int quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @JsonIgnore
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @JsonIgnore
    private Product product;
}

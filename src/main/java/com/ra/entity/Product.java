package com.ra.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String product_name;
    private String description;
    private Double price;
    private String image;
    private int stock;
    private Boolean status;


//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    @Transient
//    private List<OrderDetail> orderDetails = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @JsonIgnore
    private Category category;
}

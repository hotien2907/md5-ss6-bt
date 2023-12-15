package com.ra.entity;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    private String category_name;
    private Boolean status;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER )
    @Transient
    private List<Product> products;



}

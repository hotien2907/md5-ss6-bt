package com.ra.entity;

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
public class User {@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String user_name;
    private  String full_name;
    private String email;
    private String password;
    private String phone;
    private Byte role = 0;
    private Boolean status =true;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Orders>orders= new ArrayList<>();
}




















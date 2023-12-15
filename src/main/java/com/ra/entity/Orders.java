package com.ra.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    // Liên kết với bảng User
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    private String note;
    private String recipient_name;
    private LocalDate create_date;
    private String phone;
    private String address;
    private int status;

//    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
//    private List<OrderDetail> orderDetails = new ArrayList<>();


}

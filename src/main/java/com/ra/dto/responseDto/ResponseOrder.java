package com.ra.dto.responseDto;
import lombok.*;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResponseOrder {
    private int order_id;
    private String recipient_name;
    private String note;
    private LocalDate create_date;
    private String phone;
    private String address;
    private int status;
}

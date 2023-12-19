package com.ra.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RequestOrder {
//    @NotNull(message = "Not Null")
//    private String recipient_name;
    private String note;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate create_date;
    @Pattern(regexp = "^0\\d{9,10}$" , message = "Phone ko dung dinh dang")
    private String phone;
    @NotNull(message = "Not Null")
    private String address;
}

package com.example.universitystudentportal.dto;

import com.example.universitystudentportal.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequestDTO {

    private long amount;
    private String referenceNumber;
    private Long studentId;
    private PaymentMode paymentMode;
}

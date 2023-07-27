package com.example.universitystudentportal.dto;

import com.example.universitystudentportal.model.BaseID;
import com.example.universitystudentportal.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse extends BaseID {
    private long paymentId;
    private Long studentId;
    private String status;
    private PaymentMode paymentMode;
    private long amount;
    private Instant paymentDate;
}

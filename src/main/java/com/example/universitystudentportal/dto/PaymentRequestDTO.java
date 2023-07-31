package com.example.universitystudentportal.dto;

import com.example.universitystudentportal.generics.dto.GenericDTO;
import com.example.universitystudentportal.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequestDTO extends GenericDTO implements Serializable {

    private long amount;
    private String referenceNumber;
    private Long studentId;
    private PaymentMode paymentMode;
}

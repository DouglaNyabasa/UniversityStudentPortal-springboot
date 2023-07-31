package com.example.universitystudentportal.mapper;


import com.example.universitystudentportal.dto.PaymentRequestDTO;
import com.example.universitystudentportal.generics.mapper.EntityMapper;

import com.example.universitystudentportal.model.FeesPayment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeesPaymentMapper extends EntityMapper<PaymentRequestDTO,FeesPayment> {

    PaymentRequestDTO toDto(FeesPayment s);
}

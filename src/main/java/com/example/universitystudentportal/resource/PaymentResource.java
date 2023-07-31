package com.example.universitystudentportal.resource;

import com.example.universitystudentportal.dto.PaymentRequestDTO;
import com.example.universitystudentportal.dto.PaymentResponse;
import com.example.universitystudentportal.service.FeesPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class PaymentResource {


    private FeesPaymentService feesPaymentService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequestDTO paymentRequest){
        return  new ResponseEntity<>(
                feesPaymentService.doPayment(paymentRequest),
                HttpStatus.OK
        );
    }
    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable String orderId) {
        return new ResponseEntity<>(
                feesPaymentService.getPaymentDetailsByStudentId(Long.valueOf(orderId)),
                HttpStatus.OK
        );
    }

}

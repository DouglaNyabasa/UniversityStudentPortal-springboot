package com.example.universitystudentportal.service;

import com.example.universitystudentportal.dto.PaymentRequestDTO;
import com.example.universitystudentportal.dto.PaymentResponse;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.mapper.FeesPaymentMapper;
import com.example.universitystudentportal.model.FeesPayment;
import com.example.universitystudentportal.model.PaymentMode;
import com.example.universitystudentportal.repository.FeesPaymentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class FeesPaymentService extends GenericService<FeesPayment,Long,PaymentRequestDTO> {
    private FeesPaymentRepository feesPaymentRepository;

    protected FeesPaymentService(GenericRepository<FeesPayment> repository, FeesPaymentRepository feesPaymentRepository) {
        super(repository);
        this.feesPaymentRepository = feesPaymentRepository;
    }


    public Long doPayment(PaymentRequestDTO paymentRequestDTO){
        log.info("Recording payment details: {}", paymentRequestDTO);
        FeesPayment feesPayment = FeesPayment.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequestDTO.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .studentId(paymentRequestDTO.getStudentId())
                .amount(paymentRequestDTO.getAmount())
                .build();
        feesPaymentRepository.save(feesPayment);
        return feesPayment.getId();

    }


    public PaymentResponse getPaymentDetailsByStudentId(Long studentId){
        log.info("Getting payment details for the student Id:  {}", studentId);
        FeesPayment feesPayment = feesPaymentRepository.findByStudentId(studentId);
        PaymentResponse paymentResponse = PaymentResponse.builder()
                .paymentId(feesPayment.getId())
                .paymentDate(feesPayment.getPaymentDate())
                .paymentMode(PaymentMode.valueOf(feesPayment.getPaymentMode()))
                .status(feesPayment.getPaymentStatus())
                .amount(feesPayment.getAmount())
                .build();
        return paymentResponse;
    }

}

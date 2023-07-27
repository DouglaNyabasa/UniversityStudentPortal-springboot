package com.example.universitystudentportal.repository;

import com.example.universitystudentportal.generic.repository.GenericRepository;
import com.example.universitystudentportal.model.FeesPayment;

public interface FeesPaymentRepository extends GenericRepository<FeesPayment> {
    FeesPayment findByStudentId(Long studentId);

}

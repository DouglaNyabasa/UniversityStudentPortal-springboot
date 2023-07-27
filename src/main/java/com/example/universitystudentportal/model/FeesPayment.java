package com.example.universitystudentportal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "payment_table")
public class FeesPayment extends BaseID implements Serializable {

    private Long studentId;

    @Column(name="MODE",nullable = false)
    private String paymentMode;

    @Column(name="REFERENCE_NUMBER",unique = true,nullable = false)
    private String referenceNumber;

    @Column(name="PAYMENT_MODE",nullable = false)
    private Instant paymentDate;

    @Column(name="STATUS")
    private String paymentStatus;

    @Column(name="AMOUNT")
    private long amount;


}

package com.example.universitystudentportal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
/**
 *
 * @author Douglas Nybasa
 * created on 7/20/2023
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Salary_table")
public class Salary extends BaseID implements Serializable {

    private LocalDate dateProcessed;
    private Date period;
    private double grossAmount;
    private double deduction;
    private double taxAmount;
    private double netAmount;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Lecturer lecturer;
}

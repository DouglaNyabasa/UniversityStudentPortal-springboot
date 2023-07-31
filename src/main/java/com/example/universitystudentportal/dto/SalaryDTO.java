package com.example.universitystudentportal.dto;

import com.example.universitystudentportal.generics.dto.GenericDTO;
import com.example.universitystudentportal.model.BaseID;
import com.example.universitystudentportal.model.Lecturer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDTO extends GenericDTO {

    private LocalDate dateProcessed;
    private Date period;
    private double grossAmount;
    private double deduction;
    private double taxAmount;
    private double netAmount;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Lecturer lecturer;
}

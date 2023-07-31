package com.example.universitystudentportal.dto;

import com.example.universitystudentportal.generics.dto.GenericDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxationDTO extends GenericDTO {
    private String taxBracket;
    private double taxMinAmount;
    private double taxMaxAmount;

    private double taxPercentage;
}

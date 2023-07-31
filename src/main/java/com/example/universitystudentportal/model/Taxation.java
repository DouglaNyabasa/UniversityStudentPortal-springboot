package com.example.universitystudentportal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tax_table")
public class Taxation extends BaseID implements Serializable {
    private String taxBracket;
    private double taxMinAmount;
    private double taxMaxAmount;

    private double taxPercentage;
}

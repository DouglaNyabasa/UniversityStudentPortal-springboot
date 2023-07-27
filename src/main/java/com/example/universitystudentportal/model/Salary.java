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
@Builder
@Table(name = "Salary_table")
public class Salary extends BaseID implements Serializable {
}

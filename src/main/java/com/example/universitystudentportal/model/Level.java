package com.example.universitystudentportal.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "results_table")
public class Level extends BaseID implements Serializable {

    private String level;
}

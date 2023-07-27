package com.example.universitystudentportal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "results_table")
public class ResultsSheet extends BaseID implements Serializable {

    private int attainedMark;

    private int possibleMark;
    @OneToOne
    private Lecturer lecturer;
    @ManyToOne
    private Level level;

    @OneToOne
    private Student student;
    @ManyToOne
    private Module module;


}

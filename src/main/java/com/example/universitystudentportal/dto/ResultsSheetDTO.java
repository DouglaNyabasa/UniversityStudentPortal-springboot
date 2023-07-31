package com.example.universitystudentportal.dto;

import com.example.universitystudentportal.generics.dto.GenericDTO;
import com.example.universitystudentportal.model.Lecturer;
import com.example.universitystudentportal.model.Level;
import com.example.universitystudentportal.model.Module;
import com.example.universitystudentportal.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultsSheetDTO extends GenericDTO {
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

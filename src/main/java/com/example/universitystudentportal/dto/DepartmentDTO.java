package com.example.universitystudentportal.dto;

import com.example.universitystudentportal.generics.dto.GenericDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author Douglas Nybasa
 * created on 7/20/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO extends GenericDTO {
    private String departmentName;
}

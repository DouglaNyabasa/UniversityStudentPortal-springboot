package com.example.universitystudentportal.dto;

import com.example.universitystudentportal.generic.dto.GenericDTO;
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
public class StudentSignUpDTO extends GenericDTO {

    private String address;
    private String password;
}

package com.example.universitystudentportal.dto;

import com.example.universitystudentportal.generic.dto.GenericDTO;
import com.example.universitystudentportal.model.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class LecturerDTO extends GenericDTO {

    private Module module;


}

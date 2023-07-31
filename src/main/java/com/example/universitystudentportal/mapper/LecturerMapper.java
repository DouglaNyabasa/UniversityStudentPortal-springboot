package com.example.universitystudentportal.mapper;

import com.example.universitystudentportal.dto.LecturerDTO;
import com.example.universitystudentportal.generics.mapper.EntityMapper;
import com.example.universitystudentportal.model.Lecturer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LecturerMapper extends EntityMapper<LecturerDTO, Lecturer> {
    LecturerDTO toDto(Lecturer s);
}

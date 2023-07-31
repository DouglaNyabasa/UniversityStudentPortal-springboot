package com.example.universitystudentportal.mapper;

import com.example.universitystudentportal.dto.AdminDTO;
import com.example.universitystudentportal.dto.StudentRequest;
import com.example.universitystudentportal.generics.mapper.EntityMapper;
import com.example.universitystudentportal.model.Admin;
import com.example.universitystudentportal.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper extends EntityMapper<AdminDTO, Admin> {
    AdminDTO toDto(Admin s);
}

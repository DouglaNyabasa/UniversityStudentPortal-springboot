package com.example.universitystudentportal.mapper;

import com.example.universitystudentportal.dto.DepartmentDTO;
import com.example.universitystudentportal.generics.mapper.EntityMapper;
import com.example.universitystudentportal.model.Department;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends EntityMapper<DepartmentDTO, Department> {
    DepartmentDTO toDto(Department s);
}

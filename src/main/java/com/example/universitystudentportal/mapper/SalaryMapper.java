package com.example.universitystudentportal.mapper;

import com.example.universitystudentportal.dto.SalaryDTO;
import com.example.universitystudentportal.generics.mapper.EntityMapper;
import com.example.universitystudentportal.model.Salary;

public interface SalaryMapper extends EntityMapper<SalaryDTO, Salary> {
    SalaryDTO toDto(Salary s);
}

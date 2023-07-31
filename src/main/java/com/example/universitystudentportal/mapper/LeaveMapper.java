package com.example.universitystudentportal.mapper;

import com.example.universitystudentportal.dto.LeaveDTO;
import com.example.universitystudentportal.generics.mapper.EntityMapper;
import com.example.universitystudentportal.model.Leave;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveMapper extends EntityMapper<LeaveDTO, Leave> {
    LeaveDTO toDto(Leave s);
}

package com.example.universitystudentportal.mapper;

import com.example.universitystudentportal.dto.GuardianDTO;
import com.example.universitystudentportal.generics.mapper.EntityMapper;
import com.example.universitystudentportal.model.GuardianDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuardianDetailsMapper extends EntityMapper<GuardianDTO, GuardianDetails> {
    GuardianDTO toDto(GuardianDetails s);
}

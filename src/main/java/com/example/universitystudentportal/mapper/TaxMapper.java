package com.example.universitystudentportal.mapper;

import com.example.universitystudentportal.dto.TaxationDTO;
import com.example.universitystudentportal.generics.mapper.EntityMapper;
import com.example.universitystudentportal.model.Taxation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface TaxMapper extends EntityMapper<TaxationDTO, Taxation> {
    TaxationDTO  toDto(Taxation s);
}

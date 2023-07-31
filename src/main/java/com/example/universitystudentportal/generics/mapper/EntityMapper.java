package com.example.universitystudentportal.generics.mapper;

import com.example.universitystudentportal.generics.dto.GenericDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EntityMapper<D extends GenericDTO, E> {

    E toEntity(D genericDTO);

    D toDto(E entity);


    List<D> toDto(List<E> entityList);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    E partialUpdate(@MappingTarget E entity, D dto);
}
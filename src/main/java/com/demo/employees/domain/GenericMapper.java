package com.demo.employees.domain;

import org.mapstruct.MappingTarget;

public interface GenericMapper<E, DTO> {

    DTO map2DTO(E entity);

    E map2Entity(DTO dto);

    E map(DTO dto, @MappingTarget E entity);
}
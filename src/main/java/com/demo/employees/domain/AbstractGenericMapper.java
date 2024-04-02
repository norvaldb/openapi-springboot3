package com.demo.employees.domain;

import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;


public abstract class AbstractGenericMapper<E, DTO> implements GenericMapper<E, DTO> {

    private final CrudRepository<E, Long> repository;

    protected AbstractGenericMapper(CrudRepository<E, Long> repository) {
        this.repository = repository;
    }

    @Override
    public final E map2Entity (DTO dto) {
        if (dto == null) {
            return null;
        }

        // You can also use a Java 8 Supplier and pass it down the constructor
        E entity = newInstance();

        // Get the 'id' field from the DTO
        try {
            Field idField = dto.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            Long id = (Long) idField.get(dto);

            // Fetch the entity from the repository
            if (id != null) {
                entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new NoSuchElementException();
        }

        return map(dto, entity);
    }

    protected abstract E newInstance();
}
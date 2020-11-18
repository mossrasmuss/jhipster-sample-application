package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Property;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Property}.
 */
public interface PropertyService {

    /**
     * Save a property.
     *
     * @param property the entity to save.
     * @return the persisted entity.
     */
    Property save(Property property);

    /**
     * Get all the properties.
     *
     * @return the list of entities.
     */
    List<Property> findAll();


    /**
     * Get the "id" property.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Property> findOne(Long id);

    /**
     * Delete the "id" property.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

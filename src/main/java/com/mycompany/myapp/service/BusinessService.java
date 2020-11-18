package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Business;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Business}.
 */
public interface BusinessService {

    /**
     * Save a business.
     *
     * @param business the entity to save.
     * @return the persisted entity.
     */
    Business save(Business business);

    /**
     * Get all the businesses.
     *
     * @return the list of entities.
     */
    List<Business> findAll();


    /**
     * Get the "id" business.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Business> findOne(Long id);

    /**
     * Delete the "id" business.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

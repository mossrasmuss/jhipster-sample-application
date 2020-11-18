package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.PropertyService;
import com.mycompany.myapp.domain.Property;
import com.mycompany.myapp.repository.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Property}.
 */
@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

    private final Logger log = LoggerFactory.getLogger(PropertyServiceImpl.class);

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property save(Property property) {
        log.debug("Request to save Property : {}", property);
        return propertyRepository.save(property);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Property> findAll() {
        log.debug("Request to get all Properties");
        return propertyRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Property> findOne(Long id) {
        log.debug("Request to get Property : {}", id);
        return propertyRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Property : {}", id);
        propertyRepository.deleteById(id);
    }
}

package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.BusinessService;
import com.mycompany.myapp.domain.Business;
import com.mycompany.myapp.repository.BusinessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Business}.
 */
@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {

    private final Logger log = LoggerFactory.getLogger(BusinessServiceImpl.class);

    private final BusinessRepository businessRepository;

    public BusinessServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public Business save(Business business) {
        log.debug("Request to save Business : {}", business);
        return businessRepository.save(business);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Business> findAll() {
        log.debug("Request to get all Businesses");
        return businessRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Business> findOne(Long id) {
        log.debug("Request to get Business : {}", id);
        return businessRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Business : {}", id);
        businessRepository.deleteById(id);
    }
}

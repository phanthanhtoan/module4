package com.case_study.service.customer_type.impl;

import com.case_study.model.CustomerType;
import com.case_study.repository.customer_type.CustomerTypeRepository;
import com.case_study.service.customer_type.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;


    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void saveCustomerType(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void deleteCustomerType(Long customerTypeId) {
        customerTypeRepository.deleteById(customerTypeId);
    }

    @Override
    public CustomerType findByCustomerTypeId(Long customerTypeId) {
return customerTypeRepository.findById(customerTypeId).orElse(null);
    }

    @Override
    public Page<CustomerType> findByName(String customerTypeName, Pageable pageable) {
        return customerTypeRepository.findByCustomerTypeNameContaining(customerTypeName,pageable);
    }
}

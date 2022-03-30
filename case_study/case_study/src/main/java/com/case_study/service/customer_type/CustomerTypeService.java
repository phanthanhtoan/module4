package com.case_study.service.customer_type;

import com.case_study.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll( );
    void saveCustomerType(CustomerType customerType);
    void deleteCustomerType(Long customerTypeId );
    CustomerType findByCustomerTypeId(Long customerTypeId);
    Page<CustomerType> findByName(String customerTypeName, Pageable pageable);
}

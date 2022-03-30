package com.case_study.repository.customer_type;

import com.case_study.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
    Page<CustomerType> findAll(Pageable pageable);
    Page<CustomerType> findByCustomerTypeNameContaining(String customerTypeName, Pageable pageable);
}

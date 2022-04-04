package com.case_study.service.customer;

import com.case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    void saveCustomer(Customer customer);
    void deleteCustomer(Long customerId );
    Customer findCustomerById(Long customerId);
    Page<Customer> findByName(String customerName, Pageable pageable);

}

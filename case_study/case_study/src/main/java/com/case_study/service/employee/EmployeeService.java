package com.case_study.service.employee;

import com.case_study.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void saveEmployee(Employee employee);
    void deleteEmployee(Long employeeId);
    Employee findEmployeeById(Long employeeId);
    Page<Employee> findByName(String employeeName, Pageable pageable);
}

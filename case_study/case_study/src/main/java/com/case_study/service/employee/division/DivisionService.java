package com.case_study.service.employee.division;

import com.case_study.model.CustomerType;
import com.case_study.model.Division;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DivisionService {
    List<Division> findAll( );
    void saveDivision(Division division);
    void deleteDivision(Long divisionId );
    Division findByDivisionId(Long divisionId);
    Page<Division> findByName(String divisionName, Pageable pageable);
}

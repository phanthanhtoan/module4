package com.case_study.repository.division;

import com.case_study.model.CustomerType;
import com.case_study.model.Division;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long> {
    Page<Division> findAll(Pageable pageable);
    Page<Division> findByDivisionNameContaining(String customerTypeName, Pageable pageable);
}

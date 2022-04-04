package com.case_study.repository.education_degree;

import com.case_study.model.Division;
import com.case_study.model.EducationDegree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDegreeRepository extends JpaRepository<EducationDegree, Long> {
    Page<EducationDegree> findAll(Pageable pageable);
    Page<EducationDegree> findByEducationDegreeNameContaining(String educationDegreeName, Pageable pageable);
}

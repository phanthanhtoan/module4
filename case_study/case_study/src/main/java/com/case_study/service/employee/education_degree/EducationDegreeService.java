package com.case_study.service.employee.education_degree;

import com.case_study.model.Division;
import com.case_study.model.EducationDegree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();
    void saveEducationDegree(EducationDegree educationDegree);
    void deleteEducationDegree(Long educationDegreeId );
    EducationDegree findByEducationDegreeId(Long educationDegreeId);
    Page<EducationDegree> findByName(String educationDegreeName, Pageable pageable);
}

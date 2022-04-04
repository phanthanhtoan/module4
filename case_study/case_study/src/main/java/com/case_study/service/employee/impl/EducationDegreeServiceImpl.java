package com.case_study.service.employee.impl;

import com.case_study.model.EducationDegree;
import com.case_study.repository.education_degree.EducationDegreeRepository;
import com.case_study.service.employee.education_degree.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void saveEducationDegree(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void deleteEducationDegree(Long educationDegreeId) {
        educationDegreeRepository.deleteById(educationDegreeId);
    }

    @Override
    public EducationDegree findByEducationDegreeId(Long educationDegreeId) {
        return educationDegreeRepository.findById(educationDegreeId).orElse(null);
    }

    @Override
    public Page<EducationDegree> findByName(String educationDegreeName, Pageable pageable) {
        return educationDegreeRepository.findByEducationDegreeNameContaining(educationDegreeName, pageable);
    }
}

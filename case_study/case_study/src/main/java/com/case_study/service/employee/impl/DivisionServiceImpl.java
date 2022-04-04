package com.case_study.service.employee.impl;

import com.case_study.model.Division;
import com.case_study.repository.division.DivisionRepository;
import com.case_study.service.employee.division.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void saveDivision(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void deleteDivision(Long divisionId) {
        divisionRepository.deleteById(divisionId);
    }

    @Override
    public Division findByDivisionId(Long divisionId) {
        return divisionRepository.findById(divisionId).orElse(null);
    }

    @Override
    public Page<Division> findByName(String divisionName, Pageable pageable) {
        return divisionRepository.findByDivisionNameContaining(divisionName, pageable);
    }
}

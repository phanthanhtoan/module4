package com.case_study.service.employee.impl;

import com.case_study.model.Position;
import com.case_study.repository.position.PositionRepository;
import com.case_study.service.employee.position.PositionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void savePosition(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void deletePosition(Long positionId) {
        positionRepository.deleteById(positionId);
    }

    @Override
    public Position findByPositionId(Long positionId) {
        return positionRepository.findById(positionId).orElse(null);
    }

    @Override
    public Page<Position> findByName(String positionName, Pageable pageable) {
        return positionRepository.findAllByPositionNameContaining(positionName, pageable);
    }
}

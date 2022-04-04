package com.case_study.service.employee.position;

import com.case_study.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PositionService {
    List<Position> findAll( );
    void savePosition(Position position);
    void deletePosition(Long positionId );
    Position findByPositionId(Long positionId);
    Page<Position> findByName(String positionName, Pageable pageable);
}

package com.case_study.repository.position;

import com.case_study.model.Employee;
import com.case_study.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Page<Position> findAll(Pageable pageable);
    Page<Position> findAllByPositionNameContaining(String positionName, Pageable pageable );
}

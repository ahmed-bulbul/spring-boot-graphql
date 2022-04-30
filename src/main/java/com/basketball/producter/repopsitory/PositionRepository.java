package com.basketball.producter.repopsitory;

import com.basketball.producter.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
